package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualGenerator implements LotteryNumbersGenerator {
    private List<Integer> numbers;

    public ManualGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public LotteryNumbers generate() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (var number : numbers) {
            lotteryNumbers.add(new LotteryNumber(number));
        }
        return new LotteryNumbers(lotteryNumbers);
    }
}
