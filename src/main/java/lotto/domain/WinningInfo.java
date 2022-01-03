package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningInfo {
    public static final List<Integer> MATCH_COUNT = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
    public static final List<Integer> PRIZE = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 2000000000));

    private final List<Integer> win;
    private int returnAmount;

    public WinningInfo(List<Lotto> lottoList, List<Integer> winningNumber) {
        this.win = IntStream.iterate(0, n -> n).limit(MATCH_COUNT.size()).boxed().collect(Collectors.toList());
        this.returnAmount = 0;
        for (Lotto lotto : lottoList) {
            addWinCount(lotto, winningNumber);
        }
        for (int i = 0; i < MATCH_COUNT.size(); i++) {
            returnAmount += this.win.get(i) * PRIZE.get(i);
        }
    }

    public List<Integer> getWin() {
        return win;
    }

    public int getReturnAmount() {
        return returnAmount;
    }

    private void addWinCount(Lotto lotto, List<Integer> winningNumber) {
        int result = compare(lotto, winningNumber);
        int index_win = MATCH_COUNT.indexOf(result);
        if (index_win > -1) {
            this.win.set(index_win, this.win.get(index_win) + 1);
        }
    }

    private int compare(Lotto lotto, List<Integer> winningNumber) {
        int result = 0;
        for (int i = 0; i < Lotto.LENGTH; i++) {
            result += lotto.getNumbers().contains(winningNumber.get(i)) ? 1 : 0;
        }
        return result;
    }
}
