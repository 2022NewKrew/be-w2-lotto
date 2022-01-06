package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by melodist
 * Date: 2022-01-04 004
 * Time: 오후 5:52
 */
public class WinningLotto {
    private final List<Integer> lastWeekWinningNumbers;
    private final Integer bonusBall;

    public WinningLotto(List<Integer> lastWeekWinningNumbers, Integer bonusBall) {
        Validator.validateLottoNumbers(lastWeekWinningNumbers);
        Validator.validateLottoBonusDuplicate(lastWeekWinningNumbers, bonusBall);
        this.lastWeekWinningNumbers = lastWeekWinningNumbers;
        this.bonusBall = bonusBall;
    }

    public WinningLotto(String lastWeekWinningNumbersString, Integer bonusBall) {
        this.lastWeekWinningNumbers = createWinningLotto(lastWeekWinningNumbersString);
        Validator.validateLottoNumbers(lastWeekWinningNumbers);
        Validator.validateLottoBonusDuplicate(lastWeekWinningNumbers, bonusBall);
        this.bonusBall = bonusBall;
    }

    private List<Integer> createWinningLotto(String lottoString) {
        return Arrays.stream(lottoString.split(Constants.INPUT_MANUAL_LOTTO_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Rank matchLotto(Lotto lotto) {
        Integer winningNumberCount = lotto.matchLottoWithLastWeek(lastWeekWinningNumbers);
        boolean matchBonus = lotto.matchBonusBall(bonusBall);
        return Rank.valueOf(winningNumberCount, matchBonus);
    }
}
