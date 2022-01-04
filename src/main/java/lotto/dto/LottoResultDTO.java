package lotto.dto;

public class LottoResultDTO {

    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public LottoResultDTO() {
        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
    }

    public int getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public int getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public int getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public int getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public int getFifthPrizeCount() {
        return fifthPrizeCount;
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
}
