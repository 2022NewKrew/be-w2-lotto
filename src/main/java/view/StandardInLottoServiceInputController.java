package view;

import valid.ConditionCheck;

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
    public int getPurchaseAmount() throws InputMismatchException, IllegalArgumentException {
        System.out.println(PURCHASE_AMOUNT_REQUEST.getString());
        int amount = scan.nextInt();
        scan.nextLine();

        if(!ConditionCheck.isPositiveInteger(amount)) {
            throw new IllegalArgumentException(INPUT_ERROR.getString() + NEWLINE.getString() + PLEASE_INPUT_POSITIVE_NUMBER.getString());
        }

        return amount;
    }

    @Override
    public List<Integer> getLastWeekWinningNumber() throws InputMismatchException, IllegalArgumentException {
        System.out.println(LAST_WEEK_WINNING_NUMBER_REQUEST.getString());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(COMMA.getString())).map(Integer::valueOf).collect(Collectors.toList());

        if(!numbers.stream().allMatch(ConditionCheck::isLottoNumber)) {
            throw new IllegalArgumentException(INPUT_ERROR.getString() + NEWLINE.getString() + PLEASE_INPUT_LOTTO_NUMBER.getString());
        }

        if(!ConditionCheck.isDistinctNumbers(numbers)) {
            throw new IllegalArgumentException(INPUT_ERROR.getString() + NEWLINE.getString() + PLEASE_INPUT_NUMBER_UNIQUE.getString());
        }

        return numbers;
    }

    @Override
    public int getBonusBallNumber() throws InputMismatchException, IllegalArgumentException {
        System.out.println(BONUS_BALL_REQUEST.getString());
        int number = scan.nextInt();
        scan.nextLine();

        if(!ConditionCheck.isLottoNumber(number)) {
            throw new IllegalArgumentException(INPUT_ERROR.getString() + NEWLINE.getString() + PLEASE_INPUT_LOTTO_NUMBER.getString());
        }

        return number;
    }
}
