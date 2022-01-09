package lotto.result;

import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoResult {
    EIGHTH(0, false, 0),
    SEVENTH(1, false,0),
    SIXTH(2, false,0),
    FIFTH(3, false,5000),
    FOURTH(4, false,50000),
    THIRD(5, false,1500000),
    SECOND(5, true,30000000),
    FIRST(6, false,2000000000);

    private final int countOfMatch;
    private final boolean checkBonusBall;
    private final int winningMoney;

    LottoResult(int countOfMatch, boolean checkBonusBall, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.checkBonusBall = checkBonusBall;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean isCheckBonusBall() {
        return checkBonusBall;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoResult valueOf(int countOfMatch, boolean isBonusBall) {
        return Arrays.stream(values())
                .filter(x -> x.countOfMatch == countOfMatch && (!x.checkBonusBall || isBonusBall))
                .collect(Collectors.toList()).get(0);
    }

    public static List<LottoResult> createLottoResults(List<LottoDto> lottos, List<Integer> lastWeekLottoNumbers, int bonusBall) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoDto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(lastWeekLottoNumbers::contains).count();
            boolean isBonusBall = lotto.getNumbers().contains(bonusBall);
            lottoResults.add(valueOf(matchCount, isBonusBall));
        }
        return lottoResults;
    }
}
