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

        List<LotteryTicket> manualLotteryTickets = buyManualTickets(view, lotteryWallet);
        List<LotteryTicket> randomLotteryTickets = buyRandomTicketsAsMuchAsPossible(lotteryWallet);

        view.showBoughtTickets(new LotteryTickets(manualLotteryTickets).toDTO(), new LotteryTickets(randomLotteryTickets).toDTO());

        LotteryResult lotteryResult = view.getLotteryResult();

        manualLotteryTickets.addAll(randomLotteryTickets);
        view.showReport(new LotteryReport(new LotteryTickets(manualLotteryTickets).getPrizeCount(lotteryResult), lotteryWallet.getSpent()).toDTO());
    }

    private static List<LotteryTicket> buyManualTickets(View view, LotteryWallet lotteryWallet) {
        int numberOfManualTickets = view.getNumberOfManualTickets();
        lotteryWallet.buyTickets(numberOfManualTickets);
        return view.getLotteryTickets(numberOfManualTickets);
    }

    private static List<LotteryTicket> buyRandomTicketsAsMuchAsPossible(LotteryWallet lotteryWallet) {
        int numberOfRandomTickets = lotteryWallet.getNumberOfTicketsAffordable();
        lotteryWallet.buyTickets(numberOfRandomTickets);
        return getRandomTickets(numberOfRandomTickets);
    }

    private static List<LotteryTicket> getRandomTickets(int numberOfTickets) {
        return Stream.generate(LotteryNumbersFactory::getRandomNumbers).map(LotteryTicket::new).limit(numberOfTickets).collect(Collectors.toList());
    }
}
