package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<WinningNumber> winningNumbers;
    private final WinningNumber bonusNumber;

    public WinningNumbers(List<WinningNumber> winningNumbers, WinningNumber bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers createWinningNumbers(List<Integer> inputWinningNumbers,
        int inputBonusNumber) {
        List<WinningNumber> winningNumbers = new ArrayList<>();
        for (int inputWinningNumber : inputWinningNumbers) {
            winningNumbers.add(new WinningNumber(inputWinningNumber));
        }

        WinningNumber bonusNumber = new WinningNumber(inputBonusNumber);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }


    public Map<Rank, Integer> winningConfirmation(Lottos lottos) {
        Map<Rank, Integer> winningStatistics = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            int countOfMatch = countMatchNumber(lotto);
            boolean isMatchBonus = isMatchBonus(lotto);
            Rank rank = Rank.valueOf(countOfMatch, isMatchBonus);
            int countOfLottoByMatch = winningStatistics.getOrDefault(rank, 0);
            winningStatistics.put(rank, countOfLottoByMatch + 1);
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

    private boolean isMatchBonus(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
            .anyMatch(l -> l.getNumber() == this.bonusNumber.getNumber());
    }
}
