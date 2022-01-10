package lotto.view;

import lotto.util.Util;
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

    public static void displayPurchaseGames(int numberLotto){
        System.out.println(numberLotto + "개를 구매했습니다.");
    }

    public static void displayCandidateNumber(ArrayList CandidateNumbers){
        for (int idx = 0; idx < CandidateNumbers.size(); idx++){
            System.out.print(" "+CandidateNumbers.get(idx));
        }
        System.out.print("\n");
    }

    public static void displayWinningResults(ArrayList<Float> lottoResults){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 ("+ Util.MATCH3PRICE +"원)- "+lottoResults.get(0)+"개");
        System.out.println("4개 일치 ("+ Util.MATCH4PRICE +"원)- "+lottoResults.get(1)+"개");
        System.out.println("5개 일치 ("+ Util.MATCH5PRICE +"원)- "+lottoResults.get(2)+"개");
        System.out.println("6개 일치 ("+ Util.MATCH6PRICE +"원)- "+lottoResults.get(3)+"개");
        System.out.println("총 수익률은 "+lottoResults.get(4)+"%"+"입니다.");
    }
}
