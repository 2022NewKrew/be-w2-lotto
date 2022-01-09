package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.constant.InputMessage.*;

public class InputUtil {
    private static final int SIZE = 6;
    private static final String DELIMITER = ",";
    private static Scanner sc;

    public InputUtil() {
         this.sc = new Scanner(System.in);
    }
    public InputUtil(String input) {
         this.sc = new Scanner(input);
    }

    public int inputPrice() {
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());
        try {
            int price = Integer.parseInt(sc.nextLine());
            checkNaturalNumber(price);
            return price;
        } catch (Exception e){
            throw new IllegalArgumentException("올바르지 않은 입력값 입니다.");
        }
    }

    private void checkNaturalNumber(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        try {
            List<Integer> winningNumbers = Arrays.stream(sc.nextLine().split(DELIMITER))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            validate(winningNumbers);
            return winningNumbers;
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 입력값 입니다.");
        }
    }

    private void validate(List<Integer> winningNumbers) {
        checkCountOfNumber(winningNumbers.size());
        checkDuplicateNumbers(new HashSet<>(winningNumbers).size());
    }

    private void checkCountOfNumber(int size) {
        if (size != SIZE) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요");
        }
    }

    private void checkDuplicateNumbers(int size) {
        if (size < SIZE) {
            throw new IllegalArgumentException("숫자가 중복되지 않게 입력해주세요");
        }
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(sc.nextLine());
    }
}
