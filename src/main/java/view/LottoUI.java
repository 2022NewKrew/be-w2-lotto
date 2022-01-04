package main.java.view;

import main.java.lotto.Lotto;
import main.java.lotto.LottoGame;
import main.java.lotto.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LottoUI {
    private static Scanner sc = new Scanner(System.in);
    int money;
    ArrayList<Integer> sixNums = new ArrayList<Integer>();
    LottoGame lottoGame;

    public void startGame(){
        moneyInput();
        showLotto(lottoGame);
        sixNumInput();
        bonusInput(lottoGame);
        showWinning(lottoGame);
        showEarning(lottoGame);
    }

    private void moneyInput(){
        System.out.println("구매 금액을 입력해 주세요.");
        money = sc.nextInt();
        sc.nextLine();
        lottoGame = new LottoGame(money);
    }

    private void sixNumInput(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String sixes = sc.nextLine();
        String [] tmpSix = sixes.split(",");
        for(int i=0;i<6;i++){
            sixNums.add(Integer.valueOf(tmpSix[i].strip()));
        }
        Collections.sort(sixNums);
        lottoGame.setSixNumList(sixNums);
    }

    private void showLotto(LottoGame lottoGame){
        System.out.printf("%d개를 구매했습니다.%n",lottoGame.getLottoCount());
        for(int i=0;i<lottoGame.getLottoList().size();i++){
            lottoGame.getLottoList().get(i).printLotto();
        }
    }

    private void showWinning(LottoGame lottoGame){
        System.out.println("당첨 통계");
        System.out.println("----------");
        lottoGame.makeWinList();
        ArrayList<Integer> winList = lottoGame.getWinList();
//        ArrayList<Integer> earningList = lottoGame.getEarningList();
        LottoRank[] rank = LottoRank.values();
        for (int i=4;i>=0;i--){
            System.out.printf("%d개 일치%s (%d원)- %d개%n",rank[i].getMatch(),rank[i].getIsBonus(),rank[i].getEarning(),winList.get(i));
        }
    }

    private void bonusInput(LottoGame lottoGame){
        System.out.println("보너스 볼을 입력해 주세요.");
        lottoGame.setBonus(sc.nextInt());
        sc.nextLine();
    }

    private void showEarning(LottoGame lottoGame){
        lottoGame.setEarning();
        System.out.printf("총 수익률은 %d%%입니다.%n",lottoGame.calculate());
    }
}
