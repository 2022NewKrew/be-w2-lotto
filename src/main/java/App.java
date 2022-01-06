import domain.*;
import domain.util.LotteryNumbersFactory;
import view.View;

import java.util.stream.IntStream;

public class App {
    private static final int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        View view = new View();

        LotteryWallet lotteryWallet = new LotteryWallet(view.getBudget());
        int numberOfNonRandomTickets = view.getNumberOfNonRandomTickets();

        lotteryWallet.buyTickets(numberOfNonRandomTickets);

        LotteryTickets nonRandomLotteryTickets = new LotteryTickets(TICKET_PRICE);
        view.promptToInputLotteryNumbersToBuy();
        for (int i = 0; i < numberOfNonRandomTickets; i++) {
            nonRandomLotteryTickets.add(new LotteryTicket(view.getLotteryNumbers()));
        }

        LotteryTickets randomLotteryTickets = new LotteryTickets(TICKET_PRICE);
        addRandomTickets(randomLotteryTickets, lotteryWallet.getNumberOfTicketsAffordable());

        view.showBoughtTickets(nonRandomLotteryTickets.toDTO(), randomLotteryTickets.toDTO());

        LotteryResult lotteryResult = new LotteryResult(view.getResultNumbers(), view.getResultBonusBall());

        nonRandomLotteryTickets.add(randomLotteryTickets);
        LotteryTickets boughtLotteryTickets = nonRandomLotteryTickets;
        LotteryReport lotteryReport = new LotteryReport(boughtLotteryTickets, lotteryResult);

        view.showReport(lotteryReport.toDTO());
    }

    private static void addRandomTickets(LotteryTickets lotteryTickets, int numberOfTickets) {
        LotteryNumbersFactory lotteryNumbersFactory = new LotteryNumbersFactory();
        IntStream.range(0, numberOfTickets).forEach(i -> lotteryTickets.add(new LotteryTicket(lotteryNumbersFactory.getRandomNumbers())));
    }
}
