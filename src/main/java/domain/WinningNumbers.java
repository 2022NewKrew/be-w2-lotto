package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<WinningNumber> winningNumbers;

    public WinningNumbers(List<WinningNumber> winningNumbers) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public Map<Integer, Integer> winningConfirmation(Lottos lottos) {
        Map<Integer, Integer> winningStatistics = new HashMap<>();

        for (Lotto lotto : lottos.getLottos()) {
            int countOfMatch = countMatchNumber(lotto);
            int countOfLottoByMatch = winningStatistics.getOrDefault(countOfMatch, 0);
            winningStatistics.put(countOfMatch, countOfLottoByMatch + 1);
        }

        return winningStatistics;
    }

    private int countMatchNumber(Lotto lotto) {
        List<Integer> winningNumbers = this.winningNumbers.stream().map(WinningNumber::getNumber)
            .collect(Collectors.toList());

        return (int) lotto.getLottoNumbers().stream()
            .filter(l -> winningNumbers.contains(l.getNumber()))
            .count();
    }
}
