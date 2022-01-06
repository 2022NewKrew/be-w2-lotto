package business.domain;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class LotteryNumbers implements Iterable<LotteryNumber> {

    public static final int LOTTERY_NUMBER_COUNT = 6;

    private final Set<LotteryNumber> lotteryNumbers;

    public LotteryNumbers(Set<LotteryNumber> lotteryNumbers) {
        if (!isLotteryNumberValid(lotteryNumbers)) {
            throw new IllegalArgumentException(
                String.format("로또 번호는 중복되지 않는 %d개의 숫자만 사용 가능합니다.", LOTTERY_NUMBER_COUNT));
        }
        this.lotteryNumbers = Collections.unmodifiableSet(new TreeSet<>(lotteryNumbers));
    }

    public static LotteryNumbers from(Set<Integer> integerSet) {
        return new LotteryNumbers(
            integerSet.stream().map(LotteryNumber::from).collect(Collectors.toSet()));
    }

    public static LotteryNumbers random() {
        return new LotteryNumbers(
            Stream.generate(LotteryNumber::random).distinct().limit(LOTTERY_NUMBER_COUNT)
                .collect(Collectors.toSet()));
    }

    public BonusNumberMatched containsBonusNumber(LotteryNumber lotteryNumber) {
        return BonusNumberMatched.from(this.contains(lotteryNumber));
    }

    private boolean contains(LotteryNumber lotteryNumber) {
        return lotteryNumbers.contains(lotteryNumber);
    }

    public MatchCount calculateMatchCount(LotteryNumbers otherLotteryNumbers) {
        return MatchCount.from(
            (int) lotteryNumbers.stream().filter(otherLotteryNumbers::contains).count());
    }

    private boolean isLotteryNumberValid(Set<LotteryNumber> lotteryNumbers) {
        return lotteryNumbers.size() == LOTTERY_NUMBER_COUNT;
    }

    @Override
    public String toString() {
        return "LotteryNumbers{" + "lotteryNumbers=" + lotteryNumbers + '}';
    }

    @Override
    public Iterator<LotteryNumber> iterator() {
        return lotteryNumbers.iterator();
    }
}
