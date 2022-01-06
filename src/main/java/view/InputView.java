package view;

import domain.Lotto;
import domain.Number;
import domain.WinningLotto;
import domain.WinningLottoManual;
import exception.InvalidInputException;
import validation.Validator;

import java.util.*;
import java.util.stream.Collectors;

import static utils.Symbol.*;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    private static Validator validator = new Validator();

    public InputView() {
    }

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
        System.out.println("\n" + MANNUAL_COUNT_MESSAGE);
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
        Lotto winningLotto = getManualLotto(LAST_WEEK_WINNING_NUMBER_MESSAGE);
        Number bonusNumber = getBonusNumber(winningLotto);
        return new WinningLottoManual(winningLotto, bonusNumber);
    }

    public Lotto getManualLotto(String message) {
        List<Number> inputNumberList = getNumberList(message);
        ArrayList<Number> inputNumberArrayList = new ArrayList<Number>();
        inputNumberArrayList.addAll(inputNumberList);
        return new Lotto(inputNumberArrayList);
    }

    public List<Number> getNumberList(String Message) {
        System.out.println("\n" + Message);
        String str = sc.nextLine();
        List<Number> numberList = Arrays.stream(str.split(COMMA))
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .distinct()
                .mapToObj(n -> new Number(n))
                .collect(Collectors.toList());
        validator.isValidNumberList(numberList);
        return numberList;
    }

    public Number getBonusNumber(Lotto winningLotto) {
        System.out.println("\n" + BONUS_NUMBER_MESSAGE);
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        validator.isValidBonusNumber(winningLotto, bonusNumber);
        return new Number(bonusNumber);
    }
}
