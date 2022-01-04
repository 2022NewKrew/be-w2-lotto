package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumbersFactory {
    private LotteryNumbersFactory() {
    }

    public static LotteryNumbers create(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (var number : numbers) {
            lotteryNumbers.add(new LotteryNumber(number));
        }
        return new LotteryNumbers(lotteryNumbers);
    }
}
