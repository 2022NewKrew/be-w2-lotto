package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoResult {
    SEVENTH(0, 0),
    SIXTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int countOfMatch;
    private int winningMoney;

    private LottoResult(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoResult valueOf(int countOfMatch) {
        return Arrays.asList(values()).stream()
                .filter(x -> x.countOfMatch == countOfMatch)
                .collect(Collectors.toList()).get(0);
    }

    public static List<LottoResult> calLottoResults(List<LottoDto> lottos, List<Integer> lastWeekLottoNumbers) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoDto lotto : lottos) {
            int matchCount = lotto.getNumbers().stream()
                    .filter(lastWeekLottoNumbers::contains)
                    .collect(Collectors.toList()).size();
            lottoResults.add(LottoResult.valueOf(matchCount));
        }
        return lottoResults;
    }
}
