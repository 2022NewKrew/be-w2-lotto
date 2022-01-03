package com.cold.view;

import java.util.Scanner;

public class InputView {
  private String INPUT_PURCHASE_PRICE = "구매금액을 입력해 주세요.";
  private static String INPUT_LAST_WINNING_NUMS = "지난 주 당첨 번호를 입력해 주세요.";
  private String INVALID_PURCHASED_PRICE = "구입 금액이 음수일 수는 없습니다.";

  Scanner scanner = new Scanner(System.in);

  public int Purchase() throws Exception{
    System.out.println(INPUT_PURCHASE_PRICE);
    int purchasedPrice = scanner.nextInt();
    validatePurchasedPrice(purchasedPrice);
    int purchasedCount = calculateCount(purchasedPrice);
    return purchasedCount;
  }

  private void validatePurchasedPrice(int purchasedPrice) throws Exception{
    if(purchasedPrice < 0){
      throw new Exception(INVALID_PURCHASED_PRICE);
    }
  }

  private int calculateCount(int purchasedPrice){
    return purchasedPrice / 1000;
  }

  public String inputLastWinningNums(){
    System.out.println(INPUT_LAST_WINNING_NUMS);
    String lastWinningNums = scanner.next();
    return lastWinningNums;
  }
}
