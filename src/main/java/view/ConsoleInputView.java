package view;

import property.LottoProperties;

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
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
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
            System.exit(1);
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
            System.exit(1);
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return bonusNumber;
    }

    private void validateLotteryBuyPrice(int value) throws IllegalArgumentException {
        if (value <= 0 || value % LottoProperties.LOTTERY_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(String.format("%d원 단위의 양수만 입력 가능합니다.", LottoProperties.LOTTERY_UNIT_PRICE));
        }
    }

    private void validateLotteryNumber(int value) throws IllegalArgumentException {
        if (value < LottoProperties.LOTTERY_NUMBER_START || value > LottoProperties.LOTTERY_NUMBER_END) {
            throw new IllegalArgumentException(String.format("%d에서 %d 사이의 숫자만 입력 가능합니다.", LottoProperties.LOTTERY_NUMBER_START, LottoProperties.LOTTERY_NUMBER_END));
        }
    }

    private void validateLotteryNumberSet(Set<Integer> lotteryNumberSet) throws IllegalArgumentException {
        if (lotteryNumberSet.size() != LottoProperties.LOTTERY_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("서로 다른 %d개의 숫자만 입력 가능합니다.", LottoProperties.LOTTERY_NUMBER_COUNT));
        }
    }
}
