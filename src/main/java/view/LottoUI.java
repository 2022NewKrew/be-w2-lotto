package main.java.view;

import main.java.lotto.LottoGame;
import main.java.lotto.LottoRank;
import main.java.myexception.NumberRepetitionException;
import main.java.myexception.NotSixNumSelectedException;
import main.java.myexception.UnderThousandException;
import main.java.myexception.UnderZeroOrOverLimitException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LottoUI {
    private static Scanner sc = new Scanner(System.in);
    int money;
    ArrayList<Integer> sixNums;
    LottoGame lottoGame;

    public void startGame() throws UnderThousandException {
        moneyInput();
        validateMoneyInputUnderThousand(lottoGame);
        manualLottoSetting(lottoGame);
        inputManualLotto(lottoGame);
        showLotto(lottoGame);
        sixNumInput(lottoGame);
        bonusInput(lottoGame);
        showWinning(lottoGame);
        showEarning(lottoGame);
    }

    private void moneyInput() {
        System.out.println("구매 금액을 입력해 주세요.");
        money = sc.nextInt();
        sc.nextLine();
        lottoGame = new LottoGame(money);
    }

    private void validateMoneyInputUnderThousand(LottoGame lottoGame) throws UnderThousandException {
        try{
            lottoGame.isUnderThousand(money);
        }catch(UnderThousandException e){
            System.out.println(e.getMessage());
            moneyInput();
            validateMoneyInputUnderThousand(lottoGame);
        }
    }

    private void sixNumInput(LottoGame lottoGame){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sixNums = new ArrayList<Integer>();
        String sixes = sc.nextLine();
        String [] tmpSix = sixes.split(",");

        try{
            for(int i=0;i<6;i++){
                int tmpNum = Integer.parseInt(tmpSix[i].strip());
                lottoGame.isNumberUnderZeroOrOverLimit(tmpNum);
                sixNums.add(tmpNum);
            }
            lottoGame.isNotSixNum(sixNums);
            lottoGame.isRepetition(sixNums);
            Collections.sort(sixNums);
            lottoGame.setSixNumList(sixNums);
        }catch(UnderZeroOrOverLimitException e1) {
            System.out.println("1~45 사이의 값만 허용됩니다.");
            sixNumInput(lottoGame);
        }catch (NumberRepetitionException e2){
            System.out.println("반복된 숫자는 허용되지 않습니다.");
            sixNumInput(lottoGame);
        }catch (NotSixNumSelectedException e3){
            System.out.println("6개의 숫자를 입력해주세요");
            sixNumInput(lottoGame);
        }catch (NumberFormatException e4){
            System.out.println("숫자를 입력해주세요.");
            sixNumInput(lottoGame);
        }catch (ArrayIndexOutOfBoundsException e5){
            System.out.println("6개 숫자를 입력해주세요.");
            sixNumInput(lottoGame);
        }
    }

    private void showLotto(LottoGame lottoGame){
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
        int tmpBonus = sc.nextInt();
        sc.nextLine();
        try{
            lottoGame.isNumberUnderZeroOrOverLimit(tmpBonus);
            lottoGame.setBonus(tmpBonus);
        }catch(UnderZeroOrOverLimitException e){
            System.out.println("1~45 사이의 숫자만 입력 가능합니다.");
            bonusInput(lottoGame);
        }


    }

    private void showEarning(LottoGame lottoGame){
        lottoGame.setEarning();
        System.out.printf("총 수익률은 %d%%입니다.%n",lottoGame.calculate());
    }

    private void manualLottoSetting(LottoGame lottoGame){
        try{
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int manualCnt = sc.nextInt();
            sc.nextLine();
            lottoGame.isInvalidManualCount(manualCnt);
            lottoGame.setManualCount(manualCnt);
        }catch(UnderZeroOrOverLimitException e){
            System.out.println(e.getMessage());
            manualLottoSetting(lottoGame);
        }
    }

    private void inputManualLotto(LottoGame lottoGame){
        if(lottoGame.getManualCount()>0){
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            for(int i=0;i<lottoGame.getManualCount();i++){
                try{
                    ArrayList<Integer> lotto = new ArrayList<>();
                    String [] tmpLotto = sc.nextLine().split(",");
                    for(int j=0;j<6;j++){
                        int tmpNum = Integer.parseInt(tmpLotto[j].strip());
                        lottoGame.isNumberUnderZeroOrOverLimit(tmpNum);
                        lotto.add(tmpNum);
                    }
                    lottoGame.isRepetition(lotto);
                    lottoGame.makeManualLotto(lotto);
                }catch(UnderZeroOrOverLimitException e1) {
                    System.out.println("1~45 사이의 값만 허용됩니다.");
                    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
                    i--;
                }catch (NumberRepetitionException e2){
                    System.out.println("반복된 숫자는 허용되지 않습니다.");
                    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
                    i--;
                }catch (NumberFormatException e3){
                    System.out.println("숫자를 입력해주세요.");
                    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
                    i--;
                }catch (ArrayIndexOutOfBoundsException e4){
                    System.out.println("6개 숫자를 입력해주세요.");
                    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
                    i--;
                }
            }
        }
        lottoGame.makeLottoList();
        System.out.printf("수동으로 %d장, 자동으로 %d 개를 구매했습니다.%n",lottoGame.getManualCount(),lottoGame.getLottoCount()- lottoGame.getManualCount());
    }
}
