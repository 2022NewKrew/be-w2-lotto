package domain;

import domain.entity.Lotto;
import domain.entity.LottoPolicy;
import domain.entity.LottoResult;
import domain.entity.WinningLotto;
import view.PrintManager;

import java.util.*;

public class ResultManager {
    private final WinningLotto winningLotto;
    private final List<Lotto> purchasedLottoList;
    private final LottoPolicy lottoPolicy;

    public ResultManager(WinningLotto winningLotto, List<Lotto> purchasedLottoList) {
        this.winningLotto = winningLotto;
        this.purchasedLottoList = purchasedLottoList;
        this.lottoPolicy = new LottoPolicy();
    }

    public void getResult() {
        List<LottoResult> lottoResultList = getLottoResultList();
        Map<LottoPolicy.Rank, Integer> numOfWinningForEachRank = getNumOfWinning(lottoResultList);
        List<String> rewardsList = getRewardsList(numOfWinningForEachRank);
        PrintManager.printRewards(rewardsList);

        int totalReward = calculateReward(numOfWinningForEachRank);
        int yield = returnRate(totalReward, lottoResultList);
        PrintManager.printReturnRate(yield);
    }

    private List<String> getRewardsList(Map<LottoPolicy.Rank, Integer> numOfWinningForEachRank) {
        List<String> result = new ArrayList<>();

        for(LottoPolicy.Rank rank : numOfWinningForEachRank.keySet()) {
            String reward = getRewardString(rank, numOfWinningForEachRank.get(rank));
            result.add(reward);
        }

        return result;
    }

    private String getRewardString(LottoPolicy.Rank rank, int numOfWinning) {
        int matchedNums = lottoPolicy.rankToResult(rank).getMatchedNums();
        int winningMoney = lottoPolicy.rankToWinningMoney(rank);

        if(rank == LottoPolicy.Rank.SECOND)
            return String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개", matchedNums, winningMoney, numOfWinning);

        return String.format("%d개 일치 (%d원) - %d개", matchedNums, winningMoney, numOfWinning);
    }

    private Map<LottoPolicy.Rank, Integer> getNumOfWinning(List<LottoResult> lottoResultList) {
        Map<LottoPolicy.Rank, Integer> result = createNumOfWinningMap();

        for (LottoResult lottoResult : lottoResultList) {
            LottoPolicy.Rank rank = lottoPolicy.resultToRank(lottoResult);
            pushToMap(rank, result);
        }

        return result;
    }

    private Map<LottoPolicy.Rank, Integer> createNumOfWinningMap() {
        Map<LottoPolicy.Rank, Integer> result = new TreeMap<>();

        for (LottoPolicy.Rank rank : LottoPolicy.Rank.values()) {
            result.put(rank, 0);
        }
        result.remove(LottoPolicy.Rank.NONE);

        return result;
    }

    private void pushToMap(LottoPolicy.Rank rank, Map<LottoPolicy.Rank, Integer> winningMap) {
        if(rank == LottoPolicy.Rank.NONE)
            return;

        int currentNum = winningMap.get(rank);
        winningMap.put(rank, ++currentNum);
    }

    private List<LottoResult> getLottoResultList() {
        List<LottoResult> result = new ArrayList<>();

        for(Lotto lotto : purchasedLottoList) {
            result.add(numOfMatchedGivenLotto(lotto, winningLotto));
        }

        return result;
    }

    private LottoResult numOfMatchedGivenLotto(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> targetLotto = lotto.getLottoNumbers();

        int matchedNums = 0;
        for (int winningNum : winningLotto.getWinningNums()) {
            matchedNums += (targetLotto.contains(winningNum)) ? 1 : 0;
        }
        boolean isMatchedBonus = targetLotto.contains(winningLotto.getBonusNum());

        return new LottoResult(matchedNums, isMatchedBonus);
    }

    public int calculateReward(Map<LottoPolicy.Rank, Integer> numOfWinningForEachRank) {
        int totalReward = 0;
        for (LottoPolicy.Rank rank : numOfWinningForEachRank.keySet()) {
            // rank별 상금 * rank별 당첨 횟수
            totalReward += lottoPolicy.rankToWinningMoney(rank) * numOfWinningForEachRank.get(rank);
        }
        return totalReward;
    }

    public int returnRate(int totalReward, List<LottoResult> numOfMatchedNumbersList) {
        return (int)(totalReward / ((float)numOfMatchedNumbersList.size() * Const.PRICE_OF_LOTTO) * 100);
    }
}
