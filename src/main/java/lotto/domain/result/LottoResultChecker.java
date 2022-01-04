package lotto.domain.result;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.PlayerLotto;
import lotto.domain.player.PlayerLottoList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResultChecker {
    private final WinningLotto winningLotto;
    private final int bonusNumber;

    public LottoResultChecker(WinningLotto winnerLotto, int bonusNumber) {
        this.winningLotto = winnerLotto;
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
        List<PlayerLotto> lottoList = playerLottoList.getPlayerLottoList();
        Map<LottoRank, Integer> countRank = new HashMap<>();
        for(PlayerLotto lotto : lottoList){
            LottoRank rank = getOneLottoRank(lotto);
            countRank.put(rank, countRank.getOrDefault(rank, 0) + 1);
        }

        return countRank;
    }

    public LottoRank getOneLottoRank(PlayerLotto lotto){
        Set<Integer> set = Stream.concat(lotto.getNumbers().stream(), winningLotto.getNumbers().stream()).collect(Collectors.toSet());
        int matchingCnt = Lotto.LOTTO_NUMBER_COUNT_MAX * 2 - set.size();
        boolean matchingBonusNumber = lotto.getNumbers().contains(bonusNumber);

        return LottoRank.lookup(matchingCnt, matchingBonusNumber);
    }
}
