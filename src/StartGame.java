public class StartGame {
    public static void main(String[] args) {
        LotteryRound lotteryRound = new LotteryRound(new TestLotteryPrinter());
        lotteryRound.purchaseTickets();
        lotteryRound.drawLottery();
    }
}
