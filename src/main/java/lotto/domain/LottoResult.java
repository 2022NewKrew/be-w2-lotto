package lotto.domain;

public class LottoResult {
    private final int[] matchingReward = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    public int matchingCounts;
    public int reward;
    public int numberOfMatchingLotto;

    public LottoResult(int matchingCounts, int numberOfMatchingLotto) {
        this.matchingCounts = matchingCounts;
        this.reward = matchingReward[matchingCounts];
        this.numberOfMatchingLotto = numberOfMatchingLotto;
    }

    public long calculateEarnMoney(){
        return (long) reward * numberOfMatchingLotto;
    }
}
