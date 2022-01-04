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
        } catch (NumberFormatException | NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return lotteryBuyPrice;
    }

    @Override
    public List<Integer> getResult() {
        List<Integer> resultList = null;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            String resultString = scanner.nextLine();
            resultList = Arrays.stream(resultString.split(","))
                    .map(Integer::parseInt)
                    .peek(this::validateResult)
                    .collect(Collectors.toList());
            this.validateResultList(resultList);
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return resultList;
    }

    private void validateLotteryBuyPrice(int value) throws InputMismatchException {
        if (value <= 0 || value % lotteryRule.getLotteryUnitPrice() != 0) {
            throw new InputMismatchException();
        }
    }

    private void validateResult(int value) throws InputMismatchException {
        if (value < lotteryRule.getLotteryNumberStart() || value > lotteryRule.getLotteryNumberEnd()) {
            throw new InputMismatchException();
        }
    }

    private void validateResultList(List<Integer> resultList) throws InputMismatchException {
        if (resultList.size() != lotteryRule.getLotteryNumberCount()) {
            throw new InputMismatchException();
        }
    }
}
