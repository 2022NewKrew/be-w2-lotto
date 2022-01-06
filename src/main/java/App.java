import domain.*;
import view.View;

public class App {
    private static final int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        View view = new View();

        int budget = view.getBudget();
        int numberOfNonRandomTickets = view.getNumberOfNonRandomTickets();

        budget -= TICKET_PRICE * numberOfNonRandomTickets;
        if (budget < 0) {
            throw new IllegalArgumentException();
        }

        LotteryTickets nonRandomLotteryTickets = new LotteryTickets(TICKET_PRICE);
        view.promptToInputLotteryNumbersToBuy();
        for (int i = 0; i < numberOfNonRandomTickets; i++) {
            nonRandomLotteryTickets.add(new LotteryTicket(view.getLotteryNumbers()));
        }

        LotteryTickets randomLotteryTickets = new LotteryTickets(TICKET_PRICE);
        addRandomTicketsUnderBudget(randomLotteryTickets, budget);

        view.showBoughtTickets(nonRandomLotteryTickets.toDTO(), randomLotteryTickets.toDTO());

        LotteryResult lotteryResult = new LotteryResult(view.getResultNumbers(), view.getResultBonusBall());

        nonRandomLotteryTickets.add(randomLotteryTickets);
        LotteryTickets boughtLotteryTickets = nonRandomLotteryTickets;
        LotteryReport lotteryReport = new LotteryReport(boughtLotteryTickets, lotteryResult);

        view.showReport(lotteryReport.toDTO());
    }

    private static void addRandomTicketsUnderBudget(LotteryTickets lotteryTickets, int budget) {
        LotteryNumbersFactory lotteryNumbersFactory = new LotteryNumbersFactory();
        while (budget >= TICKET_PRICE) {
            lotteryTickets.add(new LotteryTicket(lotteryNumbersFactory.getRandomNumbers()));
            budget -= TICKET_PRICE;
        }
    }
}
