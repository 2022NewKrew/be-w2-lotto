public class StartGame {
    public static void main(String[] args) {
        LotteryRound lotteryRound = new LotteryRound(new TestLotteryController());
        lotteryRound.purchaseTickets();
        lotteryRound.drawLottery();
    }
}
