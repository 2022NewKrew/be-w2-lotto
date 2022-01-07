package business.domain;

public class LotteryResult {

    private final LotteryNumbers drawnNumbers;
    private final LotteryNumber bonusNumber;

    public LotteryResult(LotteryNumbers drawnNumbers, LotteryNumber bonusNumber) {
        if (!(isDrawnNumbersValid(drawnNumbers) && isBonusNumberValid(bonusNumber))) {
            throw new IllegalArgumentException("로또 추첨 결과를 생성할 수 없습니다.");
        }
        this.drawnNumbers = drawnNumbers;
        this.bonusNumber = bonusNumber;
    }

    private boolean isDrawnNumbersValid(LotteryNumbers drawnNumbers) {
        return drawnNumbers != null;
    }

    private boolean isBonusNumberValid(LotteryNumber bonusNumber) {
        return bonusNumber != null;
    }

    public Rank calculateRank(LotteryNumbers lotteryNumbers) {
        return Rank.valueOf(lotteryNumbers.calculateMatchCount(this.drawnNumbers),
            lotteryNumbers.containsBonusNumber(bonusNumber));
    }

    @Override
    public String toString() {
        return "LotteryResult{" + "drawnNumbers=" + drawnNumbers + ", bonusNumber=" + bonusNumber
            + '}';
    }
}
