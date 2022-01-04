package bin.jaden.be_w2_lotto.view;

import bin.jaden.be_w2_lotto.domain.Constants;
import bin.jaden.be_w2_lotto.exception.DuplicateNumberException;
import bin.jaden.be_w2_lotto.exception.InvalidNumberException;
import bin.jaden.be_w2_lotto.exception.InvalidNumbersLengthException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoScanner {
    private static final Scanner scanner = new Scanner(System.in);

    private LottoScanner() {
        // instance 생성 제한용 생성자
    }

    public static int getPurchasingAmount() {
        System.out.println(Constants.INPUT_PURCHASING_AMOUNT_MESSAGE);
        try {
            return scanPurchasingAmount();
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Constants.INPUT_WRONG_PURCHASING_AMOUNT_MESSAGE);
        } catch (InvalidNumberException invalidPurchasingAmountException) {
            System.out.println(Constants.INVALID_PURCHASING_AMOUNT_MESSAGE);
        }
        return -1;
    }

    public static List<Integer> getWinNumbers() {
        System.out.println(Constants.INPUT_WIN_NUMBERS_MESSAGE);
        try {
            return scanWinNumbers();
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Constants.INPUT_WRONG_WIN_NUMBERS_MESSAGE);
        } catch (InvalidNumberException invalidNumberException) {
            System.out.println(Constants.INVALID_WIN_NUMBERS_MESSAGE);
        } catch (InvalidNumbersLengthException invalidNumbersLengthException) {
            System.out.println(Constants.INVALID_WIN_NUMBERS_LENGTH_MESSAGE);
        }
        return null;
    }

    public static int getBonusNumbers(List<Integer> winNumbers) {
        System.out.println(Constants.INPUT_BONUS_NUMBERS_MESSAGE);
        try {
            return scanBonusNumber(winNumbers);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Constants.INVALID_BONUS_NUMBER_MESSAGE);
        } catch (InvalidNumberException invalidNumberException) {
            System.out.println(Constants.INVALID_BONUS_NUMBER_RANGE_MESSAGE);
        } catch (DuplicateNumberException duplicateNumberException) {
            System.out.println(Constants.DUPLICATE_BONUS_NUMBERS_MESSAGE);
        }
        return 0;
    }

    private static int scanPurchasingAmount() {
        String input = scanner.nextLine();
        int purchasingAmount = Integer.parseInt(input);
        if (purchasingAmount < 0)
            throw new InvalidNumberException();
        return purchasingAmount;
    }

    private static List<Integer> scanWinNumbers() {
        String string = scanner.nextLine();
        String[] numbers = string.split(Constants.INPUT_WIN_NUMBERS_DELIMITER);
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers) {
            winNumbers.add(Integer.parseInt(number));
        }
        validationCheck(winNumbers);
        return Collections.unmodifiableList(winNumbers);
    }

    private static int scanBonusNumber(List<Integer> winNumbers) {
        String input = scanner.nextLine();
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < Constants.MIN_LOTTO_NUMBER || bonusNumber > Constants.MAX_LOTTO_NUMBER)
            throw new InvalidNumberException();
        if (winNumbers.contains(bonusNumber))
            throw new DuplicateNumberException();
        return bonusNumber;
    }

    private static void validationCheck(List<Integer> winNumbers) {
        if (winNumbers.size() != Constants.NUMBERS_PER_GAME)
            throw new InvalidNumbersLengthException();
        for (int winNumber : winNumbers) {
            if (winNumber < Constants.MIN_LOTTO_NUMBER || winNumber > Constants.MAX_LOTTO_NUMBER)
                throw new InvalidNumberException();
        }

    }
}
