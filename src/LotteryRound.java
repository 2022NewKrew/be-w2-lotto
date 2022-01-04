import java.util.*;

public class LotteryRound {
    private static final int PRICE_OF_LOTTO = 1000;
    private final boolean MATCH_SUCCESS = true;

    private int purchased;
    private int numOfTickets;
    private WinningTicket winningTicket;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Integer> numberOfWinnings = new ArrayList<Integer>(Collections.nCopies(RewardRule.getRewardName().size(), 0));
    private long revenue;

    private LotteryController lotteryController;

    public LotteryRound(LotteryController lotteryController) {
        this.lotteryController = lotteryController;
    }

    public void purchaseTickets() {
        this.revenue = 0;
        this.purchased = lotteryController.inputPurchased();
        this.numOfTickets = (int) this.purchased / PRICE_OF_LOTTO;
        lotteryController.purchaseCompleted(numOfTickets);
        makeLottos();
        showLottos();
    }

    public void drawLottery() {
        this.winningTicket = new WinningTicket(lotteryController.inputWinningNumbers(), lotteryController.inputBonusBall());
        this.calculateNumberOfWinnings();
        // lotteryController.print(numberOfWinnings);
        this.caculateRevenue();
        // lotteryController.print(revenue);
        lotteryController.showStatistics(this.numberOfWinnings, (int) ((this.revenue - this.purchased) * 100 / this.purchased));
    }

    private void makeLottos() {
        for (int i = 0; i < numOfTickets; i++) {
            tickets.add(new Ticket());
        }
    }

    private void showLottos() {
        for (Ticket lotto : tickets) {
            lotteryController.print(lotto.getSelectedNumbers());
        }
    }

    private void caculateRevenue() {
        for (int i = 0; i < this.numberOfWinnings.size(); i++) {
            String rewardName = RewardRule.getRewardName().get(i);
            this.revenue += (RewardRule.valueOf(rewardName).getReward() * this.numberOfWinnings.get(i));
        }
    }

    private void calculateNumberOfWinnings() {
        for (Ticket ticket : tickets) {
            String rewardName = calculatedWinningPlace(ticket);
            addNumberOfWinnings(rewardName);
        }
    }

    private void addNumberOfWinnings(String rewardName) {
        if (Objects.equals(rewardName, "")) {
            return;
        }
        int rewardNameIndex = RewardRule.valueOf(rewardName).ordinal();
        this.numberOfWinnings.set(rewardNameIndex, this.numberOfWinnings.get(rewardNameIndex) + 1);
    }

    private String calculatedWinningPlace(Ticket ticket) {
        int matchCount = matchCountForTicket(ticket);
        boolean isBonus = isBonus(ticket);
        if (isBonus && matchCount == 5) {
            return RewardRule.getRewardNameWithBonus();
        }
        return RewardRule.getRewardNameWithoutBonus().get(matchCount);
    }

    private int matchCountForTicket(Ticket ticket) {
        int matchCount = 0;
        for (int i = 0; i < Ticket.getLength(); i++) {
            matchCount += booleanToInteger(isMatched(ticket.getSelectedNumbers().get(i)));
        }
        return matchCount;
    }

    private Boolean isMatched(int number) {
        return winningTicket.getSelectedNumbers().contains(number);
    }

    private int booleanToInteger(boolean bool) {
        if (bool) {
            return 1;
        }
        return 0;
    }

    private Boolean isBonus(Ticket ticket) {
        return ticket.getSelectedNumbers().contains(winningTicket.getBonusNumber());
    }

}
