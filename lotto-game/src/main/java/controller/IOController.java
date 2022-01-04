package controller;

import lotto.Lotto;

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
        System.out.println(label);
        return scanner.nextLine();
    }

    public static void printBuyLottoNum(int lottoNum){
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public static void printResult(int incomeRate, int firstPlaceCount, int secondPlaceCount, int thirdPlaceCount, int forthPlaceCount, int fifthPlaceCount) {
        System.out.println("당첨 통계");
        System.out.println("--------------");
        System.out.printf("3개 일치 (5000원)- %d개\n",fifthPlaceCount);
        System.out.printf("4개 일치 (50000원)- %d개\n",forthPlaceCount);
        System.out.printf("5개 일치 (1500000원)- %d개\n",thirdPlaceCount);
        System.out.printf("5개 일치,보너스 볼 일치 (30000000원)- %d개\n",secondPlaceCount);
        System.out.printf("6개 일치 (2000000000원)- %d개\n",firstPlaceCount);
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
