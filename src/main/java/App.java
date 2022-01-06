import domain.*;
import domain.util.LotteryNumbersFactory;
import view.View;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        View view = new View();
        LotteryWallet lotteryWallet = new LotteryWallet(view.getBudget());

        int numberOfManualTickets = view.getNumberOfManualTickets();
        lotteryWallet.buyTickets(numberOfManualTickets);
        List<LotteryTicket> manualLotteryTickets = view.getLotteryTickets(numberOfManualTickets);

        int numberOfRandomTickets = lotteryWallet.getNumberOfTicketsAffordable();
        lotteryWallet.buyTickets(numberOfRandomTickets);
        List<LotteryTicket> randomLotteryTickets = getRandomTickets(numberOfRandomTickets);

        view.showBoughtTickets(new LotteryTickets(manualLotteryTickets).toDTO(), new LotteryTickets(randomLotteryTickets).toDTO());

        LotteryResult lotteryResult = view.getLotteryResult();

        manualLotteryTickets.addAll(randomLotteryTickets);
        LotteryReport lotteryReport = new LotteryReport(manualLotteryTickets, lotteryResult, lotteryWallet.getSpent());

        view.showReport(lotteryReport.toDTO());
    }

    private static List<LotteryTicket> getRandomTickets(int numberOfTickets) {
        return Stream.generate(LotteryNumbersFactory::getRandomNumbers).map(LotteryTicket::new).limit(numberOfTickets).collect(Collectors.toList());
    }
}
