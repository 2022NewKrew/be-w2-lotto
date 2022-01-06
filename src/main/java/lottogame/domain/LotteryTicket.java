package lottogame.domain;

public class LotteryTicket {
    private LotteryNumbers lotteryNumbers;

    LotteryTicket(LotteryNumbers lotteryNumbers) {
        validateIsNull(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    private void validateIsNull(LotteryNumbers lotteryNumbers) {
        if (lotteryNumbers == null) {
            throw new IllegalArgumentException("로또티켓 인자로 null을 사용할 수 없습니다.");
        }
    }

    public LotteryNumbers getLotteryNumbers() {
        return lotteryNumbers;
    }

    public Rank rankTicket(LotteryNumbers winningNumbers, LotteryNumber bonusNumber) {
        Integer numberOfMatch = lotteryNumbers.countNumberOfMatch(winningNumbers);
        boolean bonusMatch = lotteryNumbers.isContain(bonusNumber);
        return Rank.valueOf(numberOfMatch, bonusMatch);
    }
}
