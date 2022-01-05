import domain.Report;
import domain.lottery.NumbersFactory;
import domain.lottery.Result;
import domain.lottery.Tickets;
import view.View;

public class App {
    public static void main(String[] args) {
        View view = new View();
        Tickets boughtTickets = new Tickets();

        boughtTickets.addRandomTicketsUnderBudget(view.getBudgetByPrompt());
        view.showBoughtTickets(boughtTickets);

        Result result = new Result(new NumbersFactory().getValidatedNumbers(view.getResultNumbersByPrompt()), view.getResultBonusBallByPrompt());
        Report report = new Report(boughtTickets, result);

        view.showReport(report.toDTO());
    }
}
