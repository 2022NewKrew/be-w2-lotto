package view;

import domain.Rule;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private final Scanner scanner;
    private final Rule lotteryRule;

    public ConsoleInputView(Rule lotteryRule) {
        scanner = new Scanner(System.in);
        this.lotteryRule = lotteryRule;
    }

    @Override
    public long getLotteryBoughtPrice() {
        int lotteryBuyPrice = 0;

        System.out.println("구입금액을 입력해 주세요.");
        try{
            lotteryBuyPrice = Integer.parseInt(scanner.nextLine());
            this.validateLotteryBuyPrice(lotteryBuyPrice);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return lotteryBuyPrice;
    }

    @Override
    public Set<Integer> getLotteryNumberSet() {
        Set<Integer> lotteryNumberSet = null;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            String lotteryNumbersString = scanner.nextLine();
            lotteryNumberSet = Arrays.stream(lotteryNumbersString.split(","))
                    .map(Integer::parseInt)
                    .peek(this::validateLotteryNumber)
                    .collect(Collectors.toSet());
            this.validateLotteryNumberSet(lotteryNumberSet);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return lotteryNumberSet;
    }

    @Override
    public int getBonusNumber() {
        int bonusNumber = 0;

        System.out.println("보너스 볼을 압력해주세요.");
        try {
            String bonusNumberString = scanner.nextLine();
            bonusNumber = Integer.parseInt(bonusNumberString);
            this.validateLotteryNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return bonusNumber;
    }

    private void validateLotteryBuyPrice(int value) throws IllegalArgumentException {
        if (value <= 0 || value % lotteryRule.getLotteryUnitPrice() != 0) {
            throw new IllegalArgumentException(String.format("%d원 단위의 양수만 입력 가능합니다.", lotteryRule.getLotteryUnitPrice()));
        }
    }

    private void validateLotteryNumber(int value) throws IllegalArgumentException {
        if (value < lotteryRule.getLotteryNumberStart() || value > lotteryRule.getLotteryNumberEnd()) {
            throw new IllegalArgumentException(String.format("%d에서 %d 사이의 숫자만 입력 가능합니다.", lotteryRule.getLotteryNumberStart(), lotteryRule.getLotteryNumberEnd()));
        }
    }

    private void validateLotteryNumberSet(Set<Integer> lotteryNumberSet) throws IllegalArgumentException {
        if (lotteryNumberSet.size() != lotteryRule.getLotteryNumberCount()) {
            throw new IllegalArgumentException(String.format("서로 다른 %d개의 숫자만 입력 가능합니다.", lotteryRule.getLotteryNumberCount()));
        }
    }
}
