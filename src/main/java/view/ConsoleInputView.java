package view;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private final Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
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
        if (value <= 0 || value % LOTTERY_UNIT_PRICE != 0) {
            throw new InputMismatchException();
        }
    }

    private void validateResult(int value) throws InputMismatchException {
        if (value <= 0 || value > 45) {
            throw new InputMismatchException();
        }
    }

    private void validateResultList(List<Integer> resultList) throws InputMismatchException {
        if (resultList.size() != 6) {
            throw new InputMismatchException();
        }
    }
}
