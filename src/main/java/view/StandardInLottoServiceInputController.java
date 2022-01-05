package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static view.Sentence.*;

public final class StandardInLottoServiceInputController implements LottoServiceInputController {

    private final Scanner scan;

    public StandardInLottoServiceInputController() {
        this.scan = new Scanner(System.in);
    }

    private int getInteger() throws InputMismatchException {
        int amount = scan.nextInt();
        scan.nextLine();

        return amount;
    }

    private List<Integer> getNumbers() throws  IllegalArgumentException {
        return Arrays.stream(scan.nextLine().replaceAll(" ", "").split(COMMA.getString()))
                .map(Integer::valueOf).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST.getString());
        try {
            return getInteger();
        } catch(InputMismatchException e) {
            scan.nextLine();
            System.out.println(INPUT_ERROR.getString());
            return getPurchaseAmount();
        }
    }

    @Override
    public int getNumberOfManualPurchase() {
        System.out.println(NUMBER_OF_MANUAL_PURCHASE_REQUEST.getString());
        try {
            return getInteger();
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println(INPUT_ERROR.getString());
            return getNumberOfManualPurchase();
        }
    }

    @Override
    public List<Integer> getManualLottoNumber() {
        try {
            return getNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_ERROR.getString());
            System.out.println(PLEASE_INPUT_NUMBERS.getString());
            return getManualLottoNumber();
        }
    }

    @Override
    public List<Integer> getLastWeekWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_REQUEST.getString());
        try {
            return getNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_ERROR.getString());
            System.out.println(PLEASE_INPUT_NUMBERS.getString());
            return getLastWeekWinningNumbers();
        }
    }

    @Override
    public int getBonusBallNumber() {
        System.out.println(BONUS_BALL_REQUEST.getString());
        try {
            return getInteger();
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println(INPUT_ERROR.getString());
            return getPurchaseAmount();
        }
    }
}
