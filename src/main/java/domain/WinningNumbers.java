package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final static String NUMBER_SIZE_ERROR_MESSAGE = "6개의 번호를 입력해주세요.";

    private static final int WINNING_NUMBERS_SIZE = 6;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers createWinningNumbers(List<Integer> inputWinningNumbers,
        int inputBonusNumber) {
        validate(inputWinningNumbers);

        List<LottoNumber> winningNumbers = inputWinningNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        LottoNumber bonusNumber = new LottoNumber(inputBonusNumber);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private static void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    public Rank countMatchNumber(Lotto lotto) {
        int countOfMatch = lotto.countMatchNumber(this.winningNumbers);
        boolean isMatchBonus = lotto.isMatchBonus(this.bonusNumber);

        return Rank.valueOf(countOfMatch, isMatchBonus);
    }
}
