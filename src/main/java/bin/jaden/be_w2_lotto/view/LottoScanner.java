package bin.jaden.be_w2_lotto.view;

import bin.jaden.be_w2_lotto.LottoGame.ManualLottoGame;
import bin.jaden.be_w2_lotto.domain.Constants;
import bin.jaden.be_w2_lotto.exception.DuplicateNumberException;
import bin.jaden.be_w2_lotto.exception.InvalidArraySizeException;
import bin.jaden.be_w2_lotto.exception.InvalidNumberException;
import bin.jaden.be_w2_lotto.exception.NumberOutOfRangeException;

import java.util.*;
import java.util.stream.Collectors;

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
        } catch (InvalidNumberException invalidNumberException) {
            System.out.println(invalidNumberException.getMessage());
        }
        return -1;
    }

    public static int getNumberOfPurchaseManually(int totalLottos) {
        System.out.println(Constants.INPUT_NUMBER_OF_PURCHASE_MANUALLY_MESSAGE);
        try {
            return scanNumberOfPurchaseManually(totalLottos);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Constants.INPUT_WRONG_NUMBER_OF_PURCHASE_MANUALLY_MESSAGE);
        } catch (InvalidNumberException | NumberOutOfRangeException exception) {
            System.out.println(exception.getMessage());
        }
        return -1;
    }

    public static List<Integer> getWinNumbers() {
        System.out.println(Constants.INPUT_WIN_NUMBERS_MESSAGE);
        try {
            return scanWinNumbers();
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Constants.INPUT_WRONG_WIN_NUMBERS_MESSAGE);
        } catch (InvalidArraySizeException | NumberOutOfRangeException | DuplicateNumberException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public static int getBonusNumbers(List<Integer> winNumbers) {
        System.out.println(Constants.INPUT_BONUS_NUMBERS_MESSAGE);
        try {
            return scanBonusNumber(winNumbers);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Constants.INVALID_BONUS_NUMBER_MESSAGE);
        } catch (InvalidNumberException | NumberOutOfRangeException | DuplicateNumberException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    private static int scanPurchasingAmount() {
        String input = scanner.nextLine();
        int purchasingAmount = Integer.parseInt(input);
        if (purchasingAmount < Constants.PRICE_PER_GAME)
            throw new InvalidNumberException(Constants.INVALID_PURCHASING_AMOUNT_MESSAGE);
        return purchasingAmount;
    }

    private static int scanNumberOfPurchaseManually(int totalLottos) {
        String input = scanner.nextLine();
        int numberOfPurchaseManually = Integer.parseInt(input);
        if (numberOfPurchaseManually < 0)
            throw new InvalidNumberException(Constants.INVALID_NUMBER_OF_PURCHASE_MANUALLY_MESSAGE);
        if (numberOfPurchaseManually > totalLottos)
            throw new NumberOutOfRangeException(Constants.INVALID_NUMBER_OF_PURCHASE_MANUALLY_RANGE_MESSAGE);
        return numberOfPurchaseManually;
    }

    private static List<Integer> scanWinNumbers() {
        String string = scanner.nextLine();
        String[] numbers = string.split(Constants.INPUT_WIN_NUMBERS_DELIMITER);

        List<Integer> winNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt).collect(Collectors.toList());
        winNumbersValidationCheck(winNumbers);
        return winNumbers;
    }

    private static int scanBonusNumber(List<Integer> winNumbers) {
        String input = scanner.nextLine();
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < Constants.MIN_LOTTO_NUMBER || bonusNumber > Constants.MAX_LOTTO_NUMBER)
            throw new NumberOutOfRangeException(Constants.INVALID_BONUS_NUMBER_RANGE_MESSAGE);
        if (winNumbers.contains(bonusNumber))
            throw new DuplicateNumberException(Constants.DUPLICATE_BONUS_NUMBERS_MESSAGE);
        return bonusNumber;
    }

    private static void winNumbersValidationCheck(List<Integer> winNumbers) {
        if (winNumbers.size() != Constants.NUMBERS_PER_GAME)
            throw new InvalidArraySizeException(Constants.INVALID_WIN_NUMBERS_LENGTH_MESSAGE);
        for (int winNumber : winNumbers) {
            if (winNumber < Constants.MIN_LOTTO_NUMBER || winNumber > Constants.MAX_LOTTO_NUMBER)
                throw new NumberOutOfRangeException(Constants.INVALID_WIN_NUMBERS_RANGE_MESSAGE);
        }
        if (winNumbers.size() != new TreeSet<>(winNumbers).size()) {
            throw new DuplicateNumberException(Constants.DUPLICATE_WIN_NUMBERS_MESSAGE);
        }
    }

    public static List<ManualLottoGame> getManualLottoGames(int numberOfPurchaseManually) {
        List<ManualLottoGame> manualLottoGames = new ArrayList<>();
        if (numberOfPurchaseManually > 0)
            System.out.println(Constants.INPUT_MANUAL_NUMBERS_MESSAGE);
        for (int i = 0; i < numberOfPurchaseManually; i++) {
            manualLottoGames.add(getManualLottoGame());
        }
        return manualLottoGames;
    }

    private static ManualLottoGame getManualLottoGame() {
        ManualLottoGame manualLottoGame = null;
        while (manualLottoGame == null) {
            manualLottoGame = scanManualLottoGame();
        }

        return manualLottoGame;
    }

    private static ManualLottoGame scanManualLottoGame() {
        String input = scanner.nextLine();
        try {
            return new ManualLottoGame(input);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Constants.INPUT_WRONG_MANUAL_NUMBERS_MESSAGE);
        } catch (InvalidArraySizeException | NumberOutOfRangeException | DuplicateNumberException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
