import domain.Report;
import domain.lottery.Result;
import domain.lottery.Ticket;
import domain.lottery.Tickets;
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

        Tickets nonRandomTickets = new Tickets(TICKET_PRICE);
        view.promptToInputLotteryNumbersToBuy();
        for (int i = 0; i < numberOfNonRandomTickets; i++) {
            nonRandomTickets.add(new Ticket(view.getLotteryNumbers()));
        }

        Tickets randomTickets = new Tickets(TICKET_PRICE);
        addRandomTicketsUnderBudget(randomTickets, budget);

        view.showBoughtTickets(nonRandomTickets.toDTO(), randomTickets.toDTO());

        Result result = new Result(view.getResultNumbers(), view.getResultBonusBall());

        nonRandomTickets.add(randomTickets);
        Tickets boughtTickets = nonRandomTickets;
        Report report = new Report(boughtTickets, result);

        view.showReport(report.toDTO());
    }

    private static void addRandomTicketsUnderBudget(Tickets tickets, int budget) {
        while (budget >= TICKET_PRICE) {
            tickets.add(new Ticket());
            budget -= TICKET_PRICE;
        }
    }
}
