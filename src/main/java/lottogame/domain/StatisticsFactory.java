package lottogame.domain;

import lottogame.dto.WinningNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticsFactory {
    private StatisticsFactory() {

    }

    public static Statistics create(LotteryTickets lotteryTickets, WinningNumbers winningNumbers) {
        List<Integer> check = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
        LotteryNumbers compareNumbers = LotteryNumbersFactory.create(winningNumbers.getNumbers());
        for (var lotteryTicket : lotteryTickets.getTickets()) {
            LotteryNumbers numbers = lotteryTicket.getLotteryNumbers();
            int count = numbers.countOfSameNumbers(compareNumbers);
            check.set(count, check.get(count) + 1);
        }

        final List<Integer> prize = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);
        List<Result> results = new ArrayList<>();
        for (int i = 6; i >= 3; i--) {
            Result result = new Result(i, prize.get(i), check.get(i));
            results.add(result);
        }

        Results test = new Results(results);
        int rate = (int) (((double) test.sumOfResults() / (lotteryTickets.getCount() * 1000)) * 100);
        return new Statistics(test, new RateOfReturn(rate));
    }
}
