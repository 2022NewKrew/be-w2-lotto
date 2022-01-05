package view;

import property.LottoProperties;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInputView implements InputView {
    private final Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public long getLotteryBoughtPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        int lotteryBuyPrice = this.getSingleInteger();
        try {
            this.validateLotteryBuyPrice(lotteryBuyPrice);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }

        return lotteryBuyPrice;
    }

    @Override
    public Set<Integer> getWinningLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return this.getLotteryNumberSet();
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 볼을 압력해주세요.");

        int bonusNumber = getSingleInteger();
        try {
            this.validateLotteryNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }

        return bonusNumber;
    }

    @Override
    public long getManualBoughtCount(long limit) {
        System.out.println("수동으로 구입할 로또 수를 입력해주세요.");

        long manualBoughtCount = this.getSingleLong();
        try {
            this.validateManualBuyCount(manualBoughtCount, limit);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }

        return manualBoughtCount;
    }

    @Override
    public List<Set<Integer>> getManualBoughtLotteriesNumbers(long count) {
        if (count != 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }

        return Stream.generate(this::getLotteryNumberSet)
                .limit(count)
                .collect(Collectors.toList());
    }

    private Set<Integer> getLotteryNumberSet() {
        Set<Integer> lotteryNumberSet = null;

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

    private void validateManualBuyCount(long value, long limit) throws IllegalArgumentException {
        if (value < 0 || value > limit) {
            throw new IllegalArgumentException(String.format("0에서 %d 사이의 숫자만 입력 가능합니다.", limit));
        }
    }
}
