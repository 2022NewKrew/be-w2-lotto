package Domain;

import Controller.*;
import Domain.Tickets.AutoTicket;
import Domain.Tickets.ManualTicket;
import Domain.Tickets.Ticket;
import Domain.Tickets.WinningTicket;

import java.util.*;

public class LotteryRound {
    private static final int PRICE_OF_LOTTO = 1000;
    private final boolean MATCH_SUCCESS = true;

    private int purchased;
    private int totalNumOfTickets;
    private int numOfManualTickets;
    private int numOfAutoTickets;
    private WinningTicket winningTicket;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Integer> numberOfWinnings = new ArrayList<Integer>(Collections.nCopies(RewardRule.getRewardName().size(), 0));
    private long revenue;

    private LotteryController lotteryController;

    public LotteryRound(LotteryController lotteryController) {
        this.lotteryController = lotteryController;
        this.revenue = 0;
    }

    public void purchaseTickets() {
        this.purchased = lotteryController.inputPurchasedPrice();
        calculateNumOfTickets();
        lotteryController.printInputManualTicketsMessage();
        for (int i = 0; i < this.numOfManualTickets; i++) {
            addManualTicket(lotteryController.inputCustomTicket());
        }
        lotteryController.purchaseCompleted(numOfManualTickets, numOfAutoTickets);
        addAutomaticTicket();
        showTickets();
    }

    private void calculateNumOfTickets() {
        this.totalNumOfTickets = (int) this.purchased / PRICE_OF_LOTTO;
        this.numOfManualTickets = lotteryController.inputNumOfManualTickets();
        this.numOfAutoTickets = this.totalNumOfTickets - this.numOfManualTickets;
    }

    public void drawLottery() {
        this.winningTicket = new WinningTicket(lotteryController.inputWinningNumbers(), lotteryController.inputBonusBall());
        this.calculateNumberOfWinnings();
        // lotteryController.print(numberOfWinnings);
        this.caculateRevenue();
        // lotteryController.print(revenue);
        lotteryController.showStatistics(this.numberOfWinnings, (int) ((this.revenue - this.purchased) * 100 / this.purchased));
    }

    private void addAutomaticTicket() {
        for (int i = 0; i < this.numOfAutoTickets; i++) {
            tickets.add(new AutoTicket());
        }
    }

    private void addManualTicket(List<Integer> selectedNumbers) {
        tickets.add(new ManualTicket(selectedNumbers));
    }

    private void showTickets() {
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
