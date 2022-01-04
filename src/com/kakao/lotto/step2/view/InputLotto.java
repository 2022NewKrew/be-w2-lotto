package com.kakao.lotto.step2.view;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputLotto {

    private int LOTTO_PRICE = 1000;

    private Scanner scanner = new Scanner(System.in);

    private void checkNegative(int number) throws Exception {
        if(number < 0)
            throw new Exception("음수 발생");
    }

    private int inputPrice() throws Exception {
        System.out.println("구입 금액을 입력해주세요.");
        int price = Integer.parseInt(scanner.nextLine());
        checkNegative(price);
        return price;
    }

    // 구입 금액을 입력받습니다. 정수가 아니거나 음수를 입력받았을 경우 다시 입력받습니다.
    public int getLottoNumber() {
        while(true) {
            try {
                return inputPrice() / LOTTO_PRICE;
            } catch (Exception exception) {
                scanner = new Scanner(System.in);
                System.out.println("0 이상의 정수를 입력하세요");
            }
        }
    }

    private void checkSize(List<Integer> winningNumbers) throws Exception {
        if(winningNumbers.size() != 6)
            throw new Exception("6개의 번호를 입력해주세요");
    }

    private void checkDuplicate(List<Integer> winningNumbers) throws Exception {
        Set<Integer> winningSet = new HashSet<>(winningNumbers);
        if(winningNumbers.size() != winningSet.size())
            throw new Exception("중복 요소가 있습니다.");
    }

    private void checkNumbers(List<Integer> winningNumbers) throws Exception {
        if((int)winningNumbers.stream().filter(number -> number > 0 && number <= 45).count()
                != winningNumbers.size())
            throw new Exception("1에서 45 사이의 숫자를 입력하세요");
    }

    private List<Integer> inputWinningNumbers() throws Exception {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Pattern.compile(", ").splitAsStream(scanner.nextLine())
                .map(string -> Integer.valueOf(string)).collect(Collectors.toList());
        checkSize(winningNumbers);
        checkDuplicate(winningNumbers);
        checkNumbers(winningNumbers);
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    // 6개의 당첨 번호를 입력받습니다. 올바른 입력이 들어올 때까지 반복문을 돕니다.
    public List<Integer> getWinningNumbers() {
        while(true) {
            try {
                return inputWinningNumbers();
            } catch(Exception exception) {
                System.out.println("1 ~ 45 사이의 정수를 ', '로 구분해 중복되지 않게 6개 입력해주세요.");
           }
        }
    }


}
