import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotteryRound {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final List<Integer> REWARDS = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    private int purchased;
    private int numOfTickets;
    private WinningTicket winningTicket;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Integer> numberOfWinnings = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
    private long revenue;

    private LotteryPrinter lotteryPrinter = new LotteryPrinter();

    public void purchaseTickets() {
        this.revenue = 0;
        this.purchased = lotteryPrinter.inputPurchased();
        this.numOfTickets = (int) this.purchased / PRICE_OF_LOTTO;
        lotteryPrinter.purchaseCompleted(numOfTickets);
        this.makeLottos();
        this.showLottos();
    }

    public void drawLottery() {
        this.winningTicket = new WinningTicket(lotteryPrinter.inputWinningNumbers());
        this.matchCountForTickets();
        lotteryPrinter.showStatistics(REWARDS, 3, 6, this.numberOfWinnings, (int) (this.revenue * 100 / this.purchased));
    }

    private void makeLottos() {
        for (int i = 0; i < numOfTickets; i++) {
            tickets.add(new Ticket());
        }
    }

    private void showLottos() {
        for (Ticket lotto : tickets) {
            lotteryPrinter.print(lotto.getTicket());
        }
    }

    private void matchCountForTickets() {
        for (Ticket lotto : tickets) {
            matchCountForSingleTicket(lotto);
        }
    }

    private void matchCountForSingleTicket(Ticket lotto) {
        int totalMatch = 0;
        for (int i = 0; i < Ticket.getLength(); i++) {
            totalMatch += numOfMatch(lotto.getTicket().get(i));
        }
        if (totalMatch >= 3) {
            this.numberOfWinnings.set(totalMatch, this.numberOfWinnings.get(totalMatch) + 1);
            this.revenue += REWARDS.get(totalMatch);
        }
    }

    private int numOfMatch(int number) {
        if (winningTicket.getTicket().contains(number)) {
            return 1;
        }
        return 0;
    }

    public static List<Integer> getRewards() { return REWARDS; }
}
