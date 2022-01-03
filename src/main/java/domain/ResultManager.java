package domain;

import domain.entity.Lotto;
import domain.entity.LottoResult;
import view.PrintManager;

import java.util.*;

public class ResultManager {
    private final List<Integer> winningNums;
    private final List<Lotto> purchasedLottoList;
    private final LottoResult lottoResult;

    public ResultManager(List<Integer> winningNums, List<Lotto> purchasedLottoList) {
        this.winningNums = winningNums;
        this.purchasedLottoList = purchasedLottoList;

        // 이거 컨트롤러 단에서 분리하면 좋을 것 같은데 일단은 넘어가자
        this.lottoResult = new LottoResult();
    }

    public void getResult() {
        List<Integer> numOfMatchedNumbersList = numOfMatched();

        Map<Integer, Integer> lottoRewards = lottoResult.getLottoResult();
        Map<Integer, Integer> rewardsForMe = new TreeMap<>();

        int totalReward = calculateReward(lottoRewards, rewardsForMe, numOfMatchedNumbersList);

        PrintManager.printRewards(lottoRewards, rewardsForMe);
        PrintManager.printReturnRate(returnRate(totalReward, numOfMatchedNumbersList));

    }

    private List<Integer> numOfMatched() {
        List<Integer> result = new ArrayList<>();

        for(Lotto lotto : purchasedLottoList) {
            result.add(numOfMatchedGivenLotto(lotto, winningNums));
        }

        return result;
    }

    private int numOfMatchedGivenLotto(Lotto lotto, List<Integer> winningNums) {
        int result = 0;
        List<Integer> targetLotto = lotto.getLottoNumbers();
        for (int winningNum : winningNums) {
            result += (targetLotto.contains(winningNum)) ? 1 : 0;
        }
        return result;
    }

    public int calculateReward(Map<Integer, Integer> lottoRewards, Map<Integer, Integer> rewardsForMe, List<Integer> numOfMatchedNumbersList) {
        int totalReward = 0;
        for (Integer matchedNum : lottoRewards.keySet()) {
            int money = lottoRewards.get(matchedNum);
            int result = Collections.frequency(numOfMatchedNumbersList, matchedNum);
            rewardsForMe.put(matchedNum, result);
            totalReward += money * result;
        }
        return totalReward;
    }

    public int returnRate(int totalReward, List<Integer> numOfMatchedNumbersList) {
        return (int)(totalReward / ((float)numOfMatchedNumbersList.size() * 1000) * 100);
    }
}
