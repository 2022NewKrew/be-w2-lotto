package lotto.domain;

import lotto.dto.LottoResultDTO;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public LottoResult() {
        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
    }

    public void plusFirstPrizeCount() {
        this.firstPrizeCount++;
    }

    public void plusSecondPrizeCount() {
        this.secondPrizeCount++;
    }

    public void plusThirdPrizeCount() {
        this.thirdPrizeCount++;
    }

    public void plusFourthPrizeCount() {
        this.fourthPrizeCount++;
    }

    public void plusFifthPrizeCount() {
        this.fifthPrizeCount++;
    }

    public LottoResultDTO toLottoResultDTO(int purchaseCount) {
        List<String> message = new ArrayList<>();
        message.add("3개 일치 (5000원)- " + fifthPrizeCount + "개");
        message.add("4개 일치 (50000원)- " + fourthPrizeCount + "개");
        message.add("5개 일치 (1500000원)- " + thirdPrizeCount + "개");
        message.add("5개 일치 (30000000원)- " + secondPrizeCount + "개");
        message.add("6개 일치 (2000000000원)- " + firstPrizeCount + "개");

        return new LottoResultDTO(message, calculateProfitRate(purchaseCount));
    }

    private double calculateProfitRate(int purchaseCount) {
        int purchaseAmount = purchaseCount * Constants.LOTTO_PRICE;
        return (getSumOfPrize() - purchaseAmount) / (double)(purchaseAmount) * 100;
    }

    private int getSumOfPrize() {
        return firstPrizeCount * PrizeType.FIRST_PRIZE.getMoney() +
                secondPrizeCount * PrizeType.SECOND_PRIZE.getMoney() +
                thirdPrizeCount * PrizeType.THIRD_PRIZE.getMoney() +
                fourthPrizeCount * PrizeType.FOURTH_PRIZE.getMoney() +
                fifthPrizeCount * PrizeType.FIFTH_PRIZE.getMoney();
    }
}
