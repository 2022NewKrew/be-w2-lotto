package lotto.controller;

import java.util.Scanner;

public class ConsoleInput {

     private static Scanner sc = new Scanner(System.in);

     public static int getLottoPurchaseMoney(){
         System.out.println("구입금액을 입력해 주세요.");
         int lottoPurChaseMoney = sc.nextInt();
         return lottoPurChaseMoney;
     }
}

