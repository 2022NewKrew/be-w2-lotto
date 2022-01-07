package ui.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ui.validation.InputValidator;
import ui.validation.InvalidInputHandler;

public class ConsoleInputView implements InputView {

    private final Scanner scanner;
    private final InputValidator inputValidator;
    private final InvalidInputHandler invalidInputHandler;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
        this.invalidInputHandler = new InvalidInputHandler();
    }

    @Override
    public long getBudget() {
        System.out.println("구입금액을 입력해 주세요.");

        long budget = this.getSingleLong();

        try {
            inputValidator.validateBudget(budget);
        } catch (IllegalArgumentException exception) {
            invalidInputHandler.handle(exception);
        }

        return budget;
    }

    @Override
    public Set<Integer> getLotteryResultNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Set<Integer> lotteryResultNumbers = this.getIntegerSet();

        try {
            inputValidator.validateLotteryNumberSet(lotteryResultNumbers);
        } catch (IllegalArgumentException exception) {
            invalidInputHandler.handle(exception);
        }

        return lotteryResultNumbers;
    }

    @Override
    public int getLotteryResultBonusNumber() {
        System.out.println("보너스 볼을 압력해주세요.");

        int bonusNumber = getSingleInteger();

        try {
            inputValidator.validateLotteryNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            invalidInputHandler.handle(exception);
        }

        return bonusNumber;
    }

    @Override
    public int getManualIssueLotteryCount(int limit) {
        System.out.println("수동으로 구입할 로또 수를 입력해주세요.");

        int manualBoughtCount = this.getSingleInteger();

        try {
            inputValidator.validateLotteryCount(manualBoughtCount, limit);
        } catch (IllegalArgumentException exception) {
            invalidInputHandler.handle(exception);
        }

        return manualBoughtCount;
    }

    @Override
    public List<Set<Integer>> getManualIssueLotteriesNumbers(int count) {
        if (count != 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }

        List<Set<Integer>> manualIssueLotteriesNumbers = Stream.generate(this::getIntegerSet)
            .limit(count).collect(Collectors.toList());

        try {
            inputValidator.validateLotteryNumberSetList(manualIssueLotteriesNumbers);
        } catch (IllegalArgumentException exception) {
            invalidInputHandler.handle(exception);
        }

        return manualIssueLotteriesNumbers;
    }

    private long getSingleLong() {
        long value = 0;

        try {
            String valueString = scanner.nextLine();
            value = Long.parseLong(valueString);
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return value;
    }

    private int getSingleInteger() {
        int value = 0;

        try {
            String valueString = scanner.nextLine();
            value = Integer.parseInt(valueString);
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return value;
    }

    private Set<Integer> getIntegerSet() {
        Set<Integer> value = null;

        try {
            String valueString = scanner.nextLine();
            value = Arrays.stream(valueString.split(",")).map(Integer::parseInt)
                .collect(Collectors.toSet());
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return value;
    }
}
