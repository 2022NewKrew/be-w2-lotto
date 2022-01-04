package lotto.domain;

public class LottoResult {

    public LottoRank rank;
    public int numberOfWinningLotteryPaper;

    public LottoResult(LottoRank rank, int numberOfWinningLotteryPaper) {
        this.rank = rank;
        this.numberOfWinningLotteryPaper = numberOfWinningLotteryPaper;
    }

    public long calculateEarnMoney(){
        return (long) rank.getReward() * numberOfWinningLotteryPaper;
    }
}
