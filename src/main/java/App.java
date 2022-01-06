import domain.*;
import domain.util.LotteryNumbersFactory;
import view.View;

import java.util.stream.IntStream;

public class App {
    private static final int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        View view = new View();

        LotteryWallet lotteryWallet = new LotteryWallet(view.getBudget());
        int numberOfManualTickets = view.getNumberOfManualTickets();

        lotteryWallet.buyTickets(numberOfManualTickets);

        LotteryTickets manualLotteryTickets = new LotteryTickets(TICKET_PRICE);
        view.promptToInputLotteryNumbersToBuy();
        for (int i = 0; i < numberOfManualTickets; i++) {
            manualLotteryTickets.add(new LotteryTicket(view.getLotteryNumbers()));
        }

        LotteryTickets randomLotteryTickets = new LotteryTickets(TICKET_PRICE);
        addRandomTickets(randomLotteryTickets, lotteryWallet.getNumberOfTicketsAffordable());

        view.showBoughtTickets(manualLotteryTickets.toDTO(), randomLotteryTickets.toDTO());

        LotteryResult lotteryResult = new LotteryResult(view.getResultNumbers(), view.getResultBonusBall());

        manualLotteryTickets.add(randomLotteryTickets);
        LotteryTickets boughtLotteryTickets = manualLotteryTickets;
        LotteryReport lotteryReport = new LotteryReport(boughtLotteryTickets, lotteryResult);

        view.showReport(lotteryReport.toDTO());
    }

    private static void addRandomTickets(LotteryTickets lotteryTickets, int numberOfTickets) {
        LotteryNumbersFactory lotteryNumbersFactory = new LotteryNumbersFactory();
        IntStream.range(0, numberOfTickets).forEach(i -> lotteryTickets.add(new LotteryTicket(lotteryNumbersFactory.getRandomNumbers())));
    }
}
