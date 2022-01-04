import domain.Agent;
import domain.User;
import domain.lottery.Tickets;
import view.View;

public class App {
    public static void main(String[] args) {
        View view = new View();
        Agent agent = new Agent();
        User user = new User(agent);

        Tickets boughtTickets = user.buyRandomTicketsUnderBudget(view.getBudgetByPrompt());
        view.showBoughtTickets(boughtTickets);

        agent.setResult(view.getResultNumbersByPrompt(), view.getResultBonusBallByPrompt());

        view.showReport(user.getReport());
    }
}
