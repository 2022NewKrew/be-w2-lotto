package lottogame.domain;

public class LotteryTicket {
    LotteryNumbers lotteryNumbers;

    LotteryTicket(LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public LotteryNumbers getLotteryNumbers() {
        return lotteryNumbers;
    }

    public String toString() {
        return lotteryNumbers.toString();
    }
}
