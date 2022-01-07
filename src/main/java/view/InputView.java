package view;

import domain.Lotto;
import domain.Number;
import domain.WinningLotto;
import domain.WinningLottoManual;
import exception.InvalidInputException;
import validation.Validator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static utils.Symbol.*;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final Validator validator = new Validator();

    public int getPurchaseAmount() throws InvalidInputException {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        try {
            int purchaseAmount = sc.nextInt();
            sc.nextLine();
            validator.isValidMoney(purchaseAmount);
            return purchaseAmount;
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }
    }

    public int getManualLottoCount(int purchaseAmount) throws InvalidInputException {
        System.out.println("\n" + MANUAL_COUNT_MESSAGE);
        try {
            int manualLottoCount = sc.nextInt();
            sc.nextLine();
            validator.isValidMannualCount(purchaseAmount, manualLottoCount);
            return manualLottoCount;
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }
    }

    public WinningLotto getWinningLotto() {
        System.out.println("\n" + LAST_WEEK_WINNING_NUMBER_MESSAGE);
        Lotto winningLotto = getManualLotto();
        Number bonusNumber = getBonusNumber();
        return new WinningLottoManual(winningLotto, bonusNumber);
    }

    public Lotto getManualLotto() {
        List<Number> inputNumberList = getNumberList();
        return new Lotto(inputNumberList);
    }

    public List<Number> getNumberList() {
        String str = sc.nextLine();
        return Arrays.stream(str.split(COMMA))
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .distinct()
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public Number getBonusNumber() {
        System.out.println("\n" + BONUS_NUMBER_MESSAGE);
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        return new Number(bonusNumber);
    }
}
