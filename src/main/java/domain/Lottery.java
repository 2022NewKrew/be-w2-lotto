package domain;

import java.util.List;

public class Lottery {

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank compareNumbers(WinningLottery winningLottery) {
        int countOfMatch = 0;
        boolean matchBonus = numbers.contains(winningLottery.getBonusNumber());

        for (Integer number : winningLottery.getWinningNumbers()) {
            countOfMatch += numbers.contains(number) ? 1 : 0;
        }

        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
