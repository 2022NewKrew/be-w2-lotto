package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final static String NUMBER_RANGE_ERROR_MESSAGE = "번호는 1이상 45이하이어야 합니다.";
    private final static String NUMBER_SIZE_ERROR_MESSAGE = "6개의 번호를 입력해주세요.";

    private static final int WINNING_NUMBERS_SIZE = 6;

    private final List<WinningNumber> winningNumbers;
    private final WinningNumber bonusNumber;

    public WinningNumbers(List<WinningNumber> winningNumbers, WinningNumber bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers createWinningNumbers(List<Integer> inputWinningNumbers,
        int inputBonusNumber) {
        validateWinningNumbers(inputWinningNumbers);
        validateNumber(inputBonusNumber);

        List<WinningNumber> winningNumbers = inputWinningNumbers.stream()
            .map(WinningNumber::new)
            .collect(Collectors.toList());

        WinningNumber bonusNumber = new WinningNumber(inputBonusNumber);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }

        for (int winningNumber : winningNumbers) {
            validateNumber(winningNumber);
        }
    }

    private static void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
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
        List<Integer> winningNumbers = this.winningNumbers.stream()
            .map(WinningNumber::getNumber)
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
