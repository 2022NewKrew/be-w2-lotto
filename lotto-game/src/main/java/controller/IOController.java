package controller;

import lotto.Lotto;
import lotto.LottoGrade;
import lotto.LottoResult;

import java.util.Scanner;

public class IOController {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getNextInt(String label){
        System.out.println(label);

        int result = scanner.nextInt();
        scanner.nextLine();

        return result;
    }

    public static String getNextString(String label){
        if(label.length() > 0) System.out.println(label);
        return scanner.nextLine();
    }

    public static void printBuyLottoNum(int manualNum, int autoNum){
        System.out.println("수동으로 " + manualNum + "장, 자동으로 " + autoNum + "장 구매했습니다.");
    }

    public static void printResult(int incomeRate, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("--------------");
        for(LottoGrade grade : LottoGrade.values()){
            if(grade != LottoGrade.SIXTH) System.out.println(grade.getCondition() + " - " + lottoResult.getResult(grade) + "개");
        }
        System.out.println("총 수익률은 " + incomeRate + "%입니다.");
    }

    public static void printLotto(Lotto lotto){
        System.out.printf("[ ");
        for(int index = 0; index < 6; index++){
            System.out.printf(lotto.getLottoNumbers().get(index) +"");
            if(index < 5) System.out.printf(", ");
        }
        System.out.printf("]\n");
    }
}
