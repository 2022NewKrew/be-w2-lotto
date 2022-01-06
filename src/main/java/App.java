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

        LotteryTickets manualLotteryTickets = buyManualTickets(view, lotteryWallet);
        LotteryTickets randomLotteryTickets = buyRandomTicketsAsMuchAsPossible(lotteryWallet);

        view.showBoughtTickets(manualLotteryTickets.toDTO(), randomLotteryTickets.toDTO());

        LotteryResult lotteryResult = view.getLotteryResult();

        LotteryTickets allTickets = new LotteryTickets(manualLotteryTickets, randomLotteryTickets);
        view.showReport(new LotteryReport(allTickets.getPrizeCount(lotteryResult), lotteryWallet.getSpent()).toDTO());
    }

    private static LotteryTickets buyManualTickets(View view, LotteryWallet lotteryWallet) {
        int numberOfManualTickets = view.getNumberOfManualTickets();
        lotteryWallet.buyTickets(numberOfManualTickets);
        return new LotteryTickets(view.getLotteryTickets(numberOfManualTickets));
    }

    private static LotteryTickets buyRandomTicketsAsMuchAsPossible(LotteryWallet lotteryWallet) {
        int numberOfRandomTickets = lotteryWallet.getNumberOfTicketsAffordable();
        lotteryWallet.buyTickets(numberOfRandomTickets);
        return new LotteryTickets(getRandomTickets(numberOfRandomTickets));
    }

    private static List<LotteryTicket> getRandomTickets(int numberOfTickets) {
        return Stream.generate(LotteryNumbersFactory::getRandomNumbers).map(LotteryTicket::new).limit(numberOfTickets).collect(Collectors.toList());
    }
}
