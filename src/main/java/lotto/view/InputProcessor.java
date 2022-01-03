package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.constant.Constants.*;

public class InputProcessor {

    private final static Scanner SCANNER = new Scanner(System.in);

    /*
    구매 금액을 입력받는 메소드
    RuntimeException 발생 시 다시 입력 받도록 구현했음.
        - NumberFormatException     : 사용자가 입력한 금액이 숫자 형태가 아닐 시 발생
        - IllegalArgumentException  : 사용자가 입력한 금액이 0원 이하이거나, 로또 낱개 금액의 배수가 아닐 시 발생
     */
    public static long inputPurchaseAmount() {
        String inputString = input(PURCHASE_MONEY_INPUT_MESSAGE);

        try {
            return parseAmount(inputString);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    /*
    구매 금액을 입력받는 메소드
    RuntimeException 발생 시 다시 입력 받도록 구현했음.
        - NumberFormatException     : 사용자가 입력한 당첨 번호 중, 숫자 형태가 아닌 것이 있을 시 발생
        - IllegalArgumentException  : 사용자가 입력한 당첨 번호의 개수가 6개가 아니거나,
                                      당첨 번호들 중 로또 번호의 범위를 벗어나는 숫자가 있을 시 발생
     */
    public static List<Integer> inputWinningNumber() {
        String inputString = input(WINNING_NUMBERS_INPUT_MESSAGE);

        try {
            return parseWinningNumber(inputString);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    private static long parseAmount(String moneyString) {
        long money;
        try {
            money = Long.parseLong(moneyString);
        } catch(NumberFormatException nfe) {
            throw new NumberFormatException(PURCHASE_MONEY_ONLY_NUMBER_MESSAGE);
        }

        if(validateMoney(money)) {
            return money / PRICE_OF_LOTTO;
        }
        throw new IllegalArgumentException(PURCHASE_MONEY_ONLY_MULTIPLE_OF_PRICE_MESSAGE);
    }

    private static boolean validateMoney(long money) {
        return money > 0L && money % PRICE_OF_LOTTO == 0L;
    }

    private static List<Integer> parseWinningNumber(String inputText) {
        String[] tokens = inputText.split(", ");
        if(tokens.length != NUM_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NEED_6_MESSAGE);
        }

        return Arrays.stream(tokens)
                    .map(InputProcessor::parseNumberEach)
                    .collect(Collectors.toList());
    }

    private static Integer parseNumberEach(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch(NumberFormatException nfe) {
            throw new NumberFormatException(WINNING_NUMBERS_ONLY_NUMBER_MESSAGE);
        }

        if(validateWinningNumber(number)) {
            return number;
        }
        throw new IllegalArgumentException(WINNING_NUMBERS_IN_RANGE_MESSAGE);
    }

    private static boolean validateWinningNumber(int number) {
        return LOTTO_START_NUMBER <= number && number <= LOTTO_END_NUMBER;
    }

    private static String input(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
