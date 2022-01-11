package lotto.view;

import lotto.domain.Lotto;
import lotto.util.Util;
import lotto.util.Rank;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.List;

public class Interface {

    static Scanner sc = new Scanner(System.in);

    public static int getPurchaseAmount(){
        System.out.println("구매금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static ArrayList getWinningNumber(){
        String numberLine;
        ArrayList<Integer> lastLottoNumbers;
        List<String> list;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        numberLine = sc.next();
        list = Arrays.asList(numberLine.split(","));
        try{
            lastLottoNumbers = new ArrayList<Integer>(list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));
        } catch(NumberFormatException e){
            lastLottoNumbers = new ArrayList<>();
        }
        return lastLottoNumbers;
    }

    public static int getBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    public static void displayPurchaseGames(int numberLotto){
        System.out.println(numberLotto + "개를 구매했습니다.");
    }

    public static void displayCandidateNumber(ArrayList CandidateNumbers){
        for (int idx = 0; idx < CandidateNumbers.size(); idx++){
            System.out.print(" "+CandidateNumbers.get(idx));
        }
        System.out.print("\n");
    }

    public static void displayWinningResults(Lotto lottoResults){
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : lottoResults.getWinningCases()){
            System.out.println(rank.getCountOfMatch()+"개 일치 ("+ rank.getWinningMoney() +"원)- "+rank.getResultCount()+"개");
        }
        System.out.println("총 수익률은 "+lottoResults.checkWinningRate()+"%"+"입니다.");
    }
}
