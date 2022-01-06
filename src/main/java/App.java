import domain.*;
import domain.util.LotteryNumbersFactory;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        View view = new View();

        LotteryWallet lotteryWallet = new LotteryWallet(view.getBudget());
        int numberOfManualTickets = view.getNumberOfManualTickets();

        lotteryWallet.buyTickets(numberOfManualTickets);
        List<LotteryTicket> manualLotteryTicketsAsList = view.getLotteryTickets(numberOfManualTickets);

        int numberOfRandomTickets = lotteryWallet.getNumberOfTicketsAffordable();
        lotteryWallet.buyTickets(numberOfRandomTickets);
        List<LotteryTicket> randomLotteryTicketsAsList = getRandomTickets(numberOfRandomTickets);

        view.showBoughtTickets(new ReducedLotteryTickets(manualLotteryTicketsAsList).toDTO(), new ReducedLotteryTickets(randomLotteryTicketsAsList).toDTO());

        LotteryResult lotteryResult = view.getLotteryResult();

        manualLotteryTicketsAsList.addAll(randomLotteryTicketsAsList);
        LotteryReport lotteryReport = new LotteryReport(manualLotteryTicketsAsList, lotteryResult, lotteryWallet.getSpent());

        view.showReport(lotteryReport.toDTO());
    }

    private static List<LotteryTicket> getRandomTickets(int numberOfTickets) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        LotteryNumbersFactory lotteryNumbersFactory = new LotteryNumbersFactory();
        IntStream.range(0, numberOfTickets).forEach(i -> lotteryTickets.add(new LotteryTicket(lotteryNumbersFactory.getRandomNumbers())));
        return lotteryTickets;
    }
}
