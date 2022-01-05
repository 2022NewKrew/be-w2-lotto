package lotto.view;

import lotto.constant.WinningType;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static lotto.constant.Constants.*;

public class IOView {

    private final static Scanner SCANNER = new Scanner(System.in);

    /*
    구매 금액을 입력받는 메소드
    RuntimeException 발생 시 다시 입력 받도록 구현했음.
        - NumberFormatException     : 사용자가 입력한 금액이 숫자 형태가 아닐 시 발생
        - IllegalArgumentException  : 사용자가 입력한 금액이 0원 이하이거나, 로또 낱개 금액의 배수가 아닐 시 발생
     */
    public static long inputTotalPurchaseAmount() {
        String inputString = input(PURCHASE_MONEY_INPUT_MESSAGE);

        try {
            return parseAmount(inputString);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return inputTotalPurchaseAmount();
        }
    }

    /*
    당첨 번호를 입력받는 메소드
    RuntimeException 발생 시 다시 입력 받도록 구현했음.
        - NumberFormatException     : 사용자가 입력한 당첨 번호 중, 숫자 형태가 아닌 것이 있을 시 발생
        - IllegalArgumentException  : 사용자가 입력한 당첨 번호의 개수가 6개가 아니거나,
                                      당첨 번호들 중 로또 번호의 범위를 벗어나는 숫자가 있을 시 발생
     */
    public static List<Integer> inputWinningNumber() {
        String inputString = input(WINNING_NUMBERS_INPUT_MESSAGE);

        try {
            return parseLottoNumber(inputString);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    /*
    보너스 번호를 입력받는 메소드
    RuntimeException 발생 시 다시 입력 받도록 구현했음.
        - NumberFormatException     : 사용자가 입력한 보너스 번호가 숫자 형태가 아닐 시 발생
        - IllegalArgumentException  : 사용자가 입력한 보너스 번호가 로또 번호의 범위를 벗어나거나,
                                      이미 당첨 로또 번호 안에 있을 시 발생
     */
    public static int inputBonusNumber(List<Integer> winningNumbers) {
        String inputString = input(BONUS_NUMBER_INPUT_MESSAGE);

        try {
            return parseNumberEach(inputString, winningNumbers);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

    /*
    수동 구매할 양을 입력받는 메소드
    RuntimeException 발생 시 다시 입력 받도록 구현했음.
        - NumberFormatException     : 사용자가 입력한 수동 구매할 양이 숫자 형태가 아닐 시 발생
        - IllegalArgumentException  : 사용자가 입력한 수동 구매할 양이 음수이거나, 총 구매하는 양보다 많을 시 발생
     */
    public static long inputManualAmount(long totalPurchaseAmount) {
        String inputString = input(MANUAL_AMOUNT_INPUT_MESSAGE);
        try {
            return parseManualAmount(inputString, totalPurchaseAmount);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return inputManualAmount(totalPurchaseAmount);
        }
    }

    /*
    수동 구매하는 로또의 번호를 입력받는 메소드
    RuntimeException 발생 시 다시 입력 받도록 구현했음.
        - NumberFormatException     : 사용자가 입력한 수동 구매 번호가 숫자 형태가 아닐 시 발생
        - IllegalArgumentException  : 사용자가 입력한 수동 구매 번호가 로또 번호의 범위를 벗어나거나,
                                      번호를 6개 이상 불렀거나, 겹치는 번호가 있을 시 발생
     */
    public static List<List<Integer>> inputManualLottoNumbers(long manualAmount) {
        if(manualAmount == 0) {
            return new ArrayList<>();
        }
        System.out.println(MANUAL_LOTTO_NUMBERS_INPUT_MESSAGE);

        return LongStream.rangeClosed(1, manualAmount)
                .mapToObj(IOView::inputManualLottoNumber)
                .collect(Collectors.toList());
    }

    private static List<Integer> inputManualLottoNumber(long idx) {
        String inputString = input(String.format("%d번째 수동 구매 번호 입력", idx));

        try {
            return parseLottoNumber(inputString);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return inputManualLottoNumber(idx);
        }
    }

    private static long parseAmount(String moneyString) {
        long money;
        try {
            money = Long.parseLong(moneyString);
        } catch(NumberFormatException nfe) {
            throw new NumberFormatException(PURCHASE_MONEY_ONLY_NUMBER_ERROR_MESSAGE);
        }

        if(validateMoney(money)) {
            return money / PRICE_OF_LOTTO;
        }
        throw new IllegalArgumentException(PURCHASE_MONEY_ONLY_MULTIPLE_OF_PRICE_ERROR_MESSAGE);
    }

    private static boolean validateMoney(long money) {
        return money > 0L && money % PRICE_OF_LOTTO == 0L;
    }

    private static List<Integer> parseLottoNumber(String inputText) {
        String[] tokens = inputText.split(SPLIT_DELIMITER);
        if(tokens.length != NUM_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NEED_6_ERROR_MESSAGE);
        }
        List<Integer> numbers = Arrays.stream(tokens)
                .map(token -> parseNumberEach(token, null))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        if(numbers.size() == NUM_OF_WINNING_NUMBERS) {
            return numbers;
        }
        throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_DUPLICATE_ERROR_MESSAGE);
    }

    private static Integer parseNumberEach(String token, List<Integer> winningNumbers) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch(NumberFormatException nfe) {
            throw new NumberFormatException(LOTTO_NUMBERS_ONLY_NUMBER_ERROR_MESSAGE);
        }

        if(!validateWinningNumber(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_IN_RANGE_ERROR_MESSAGE);
        }
        if(isInLottoNumbers(number, winningNumbers)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_IN_LOTTO_NUMBERS_ERROR_MESSAGE);
        }
        return number;
    }

    private static boolean isInLottoNumbers(int number, List<Integer> winningNumbers) {
        if(winningNumbers == null) {
            return false;
        }
        return winningNumbers.contains(number);
    }

    private static boolean validateWinningNumber(int number) {
        return LOTTO_START_NUMBER <= number && number <= LOTTO_END_NUMBER;
    }

    private static long parseManualAmount(String inputString, long totalPurchaseAmount) {
        long manualAmount;
        try {
            manualAmount = Long.parseLong(inputString);
        } catch(NumberFormatException nfe) {
            throw new NumberFormatException(PURCHASE_MONEY_ONLY_NUMBER_ERROR_MESSAGE);
        }

        if(validateManualAmount(manualAmount, totalPurchaseAmount)) {
            return manualAmount;
        }
        throw new IllegalArgumentException(MANUAL_AMOUNT_LESS_THAN_TOTAL_AMOUNT_MESSAGE);
    }

    private static boolean validateManualAmount(long manualAmount, long totalPurchaseAmount) {
        return manualAmount >= 0 && totalPurchaseAmount >= manualAmount;
    }

    private static String input(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

    public static void  printLottoList(List<Lotto> lottoList, long purchaseAmount, long manualAmount) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PURCHASE_LOTTO_MESSAGE, manualAmount, purchaseAmount - manualAmount)).append(NEW_LINE);
        lottoList.forEach(lotto -> sb.append(lotto).append(NEW_LINE));

        System.out.println(sb);
    }

    public static void printLottoResult(LottoGame lottoGame) {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_TITLE).append(NEW_LINE).append(PARTITION).append(NEW_LINE);

        IntStream.rangeClosed(MIN_MATCHING_NUM_TO_WINNING, MAX_MATCHING_NUM_TO_WINNING)
                .forEach(match -> {
                    WinningType type = WinningType.findType(match);
                    sb.append(String.format(WINNING_MESSAGE_FORMAT, type.getMessage(), type.getPrizeMoney(), lottoGame.getLotteryResult().get(match)))
                      .append(NEW_LINE);
                });

        sb.append(String.format(EARNING_RATE_MSG_FORMAT, lottoGame.getEarningRate()));

        System.out.println(sb);
    }
}
