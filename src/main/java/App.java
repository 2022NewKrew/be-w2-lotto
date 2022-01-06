import domain.*;
import domain.util.LotteryNumbersFactory;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class App {
    private static final int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        View view = new View();

        LotteryWallet lotteryWallet = new LotteryWallet(view.getBudget());
        int numberOfManualTickets = view.getNumberOfManualTickets();


        /*LotteryTickets manualLotteryTickets = new LotteryTickets(TICKET_PRICE);
        view.promptToInputLotteryNumbersToBuy();
        for (int i = 0; i < numberOfManualTickets; i++) {
            manualLotteryTickets.add(new LotteryTicket(view.getLotteryNumbers()));
        }*/
        lotteryWallet.buyTickets(numberOfManualTickets);
        List<LotteryTicket> manualLotteryTicketsAsList = view.getLotteryTickets(numberOfManualTickets);


        /*LotteryTickets randomLotteryTickets = new LotteryTickets(TICKET_PRICE);
        addRandomTickets(randomLotteryTickets, lotteryWallet.getNumberOfTicketsAffordable());*/
        int numberOfRandomTickets = lotteryWallet.getNumberOfTicketsAffordable();
        lotteryWallet.buyTickets(numberOfRandomTickets);
        List<LotteryTicket> randomLotteryTicketsAsList = getRandomTickets(numberOfRandomTickets);


        // view.showBoughtTickets(manualLotteryTickets.toDTO(), randomLotteryTickets.toDTO());
        view.showBoughtTickets(new ReducedLotteryTickets(manualLotteryTicketsAsList).toDTO(), new ReducedLotteryTickets(randomLotteryTicketsAsList).toDTO());


        // LotteryResult lotteryResult = new LotteryResult(view.getResultNumbers(), view.getResultBonusBall());
        LotteryResult lotteryResult = view.getLotteryResult();


        /*manualLotteryTickets.add(randomLotteryTickets);
        LotteryTickets boughtLotteryTickets = manualLotteryTickets;
        LotteryReport lotteryReport = new LotteryReport(boughtLotteryTickets, lotteryResult);*/
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

    private static void addRandomTickets(LotteryTickets lotteryTickets, int numberOfTickets) {
        LotteryNumbersFactory lotteryNumbersFactory = new LotteryNumbersFactory();
        IntStream.range(0, numberOfTickets).forEach(i -> lotteryTickets.add(new LotteryTicket(lotteryNumbersFactory.getRandomNumbers())));
    }
}
