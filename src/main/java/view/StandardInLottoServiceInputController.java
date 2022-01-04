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

    @Override
    public int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST.getString());
        try {
            int amount = scan.nextInt();
            scan.nextLine();

            return amount;
        } catch (InputMismatchException e) {
            System.out.println(INPUT_ERROR.getString());
            return getPurchaseAmount();
        }
    }

    @Override
    public List<Integer> getLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_REQUEST.getString());
        try {
            return Arrays.stream(scan.nextLine().replaceAll(" ", "").split(COMMA.getString()))
                    .map(Integer::valueOf).collect(Collectors.toUnmodifiableList());
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_ERROR.getString());
            System.out.println(PLEASE_INPUT_NUMBERS.getString());
            return getLastWeekWinningNumber();
        }
    }

    @Override
    public int getBonusBallNumber() {
        System.out.println(BONUS_BALL_REQUEST.getString());
        try {
            int number = scan.nextInt();
            scan.nextLine();

            return number;
        } catch (InputMismatchException e) {
            System.out.println(INPUT_ERROR.getString());
            return getPurchaseAmount();
        }
    }
}
