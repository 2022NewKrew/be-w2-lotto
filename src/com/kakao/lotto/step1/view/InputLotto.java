package com.kakao.lotto.step1.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputLotto {

    static private Scanner scanner = new Scanner(System.in);

    static private void checkNegative(int number) throws Exception {
        if(number < 0)
            throw new Exception("음수 발생");
    }

    static private int inputPrice() throws Exception {
        System.out.println("구입 금액을 입력해주세요.");
        int price = scanner.nextInt();
        checkNegative(price);
        scanner.nextLine();
        return price;
    }

    // 구입 금액을 입력받습니다. 정수가 아니거나 음수를 입력받았을 경우 다시 입력받습니다.
    static public int getPrice() {
        while(true) {
            try {
                return inputPrice();
            } catch (Exception exception) {
                scanner = new Scanner(System.in);
                System.out.println("0 이상의 정수를 입력하세요");
            }
        }
    }

    static private List<Integer> stringToList() throws Exception {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<String> stringWinningNumbers = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));
        if(stringWinningNumbers.size() != 6)
            throw new Exception("6개의 번호를 입력해주세요");
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i = 0; i < stringWinningNumbers.size(); i++)
            winningNumbers.add(Integer.valueOf(stringWinningNumbers.get(i)));
        return winningNumbers;
    }

    // 6개의 당첨 번호를 입력받습니다. 올바른 입력이 들어올 때까지 반복문을 돕니다.
    static public List<Integer> inputWinningNumbers() {
        while(true) {
            try {
                return stringToList();
            } catch(Exception exception) {
                scanner = new Scanner(System.in);
                System.out.println("1 ~ 45 사이의 정수를 ', '로 구분해 6개 입력해주세요.");
           }
        }
    }

    // 구매한 로또의 개수를 출력해줍니다.
    static public void printBuyLottoNumber(int lottoNumber) {
        System.out.println(lottoNumber + "개를 구매했습니다.");
    }
}
