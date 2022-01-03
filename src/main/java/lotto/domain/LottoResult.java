package lotto.domain;

public class LottoResult {
    private final int[] matchingReward = {0, 0, 0, 5000, 50000, 150000, 25000000};

    public int matchingCounts;
    public int reward;
    public int numberOfMatchingLotto;

    public LottoResult(int matchingCounts, int numberOfMatchingLotto) {
        this.matchingCounts = matchingCounts;
        this.reward = matchingReward[matchingCounts];
        this.numberOfMatchingLotto = numberOfMatchingLotto;
    }
}
