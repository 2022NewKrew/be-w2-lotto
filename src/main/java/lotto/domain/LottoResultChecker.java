package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResultChecker {
    private static final int LOTTO_NUMBER_COUNT_MAX = 6;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> getLottoResults(PlayerLottoList playerLottoList) {
        List<LottoResult> lottoResults = new ArrayList<>();
        Map<LottoRank, Integer> countRank = getAllLottoRank(playerLottoList);
        for (LottoRank rank : LottoRank.values()){
            lottoResults.add(new LottoResult(rank, countRank.getOrDefault(rank, 0)));
        }
        return lottoResults;
    }

    private Map<LottoRank, Integer> getAllLottoRank(PlayerLottoList playerLottoList){
        List<Lotto> lottoList = playerLottoList.getLottoList();
        Map<LottoRank, Integer> countRank = new HashMap<>();
        for(Lotto lotto : lottoList){
            LottoRank rank = getOneLottoRank(lotto);
            countRank.put(rank, countRank.getOrDefault(rank, 0) + 1);
        }
        return countRank;
    }

    public LottoRank getOneLottoRank(Lotto lotto){
        Set<Integer> set = Stream.concat(lotto.getNumbers().stream(), winningNumbers.stream()).collect(Collectors.toSet());
        int matchingCnt = LOTTO_NUMBER_COUNT_MAX * 2 - set.size();
        boolean matchingBonusNumber = lotto.getNumbers().contains(bonusNumber);
        return LottoRank.lookup(matchingCnt, matchingBonusNumber);
    }
}
