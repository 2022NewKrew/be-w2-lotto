package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import domain.Lottery;

public class LotteryGenerator {
    private static final List<Integer> allNumbers = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
    }

    private LotteryGenerator() {
    }

    public static List<Lottery> manualLotteriesGenerator(List<List<Integer>> manualNumbers) {
        return manualNumbers.stream()
                            .map(Lottery::new)
                            .collect(Collectors.toList());
    }

    public static List<Lottery> randomLotteriesGenerator(int lotteryCount) {
        List<Lottery> lotteries = new ArrayList<>();

        for (int i = 0; i < lotteryCount; ++i) {
            lotteries.add(randomLotteryGenerator());
        }

        return lotteries;
    }

    private static Lottery randomLotteryGenerator() {
        Collections.shuffle(allNumbers);
        List<Integer> randomNumbers = allNumbers.subList(0, 6);
        Collections.sort(randomNumbers);
        return new Lottery(randomNumbers);
    }
}

