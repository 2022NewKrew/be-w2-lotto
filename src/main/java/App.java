import domain.Agent;
import domain.User;
import domain.lottery.Ticket;
import view.View;

import java.util.List;

public class App {
    public static void main(String[] args) {
        View view = new View();
        Agent agent = new Agent();
        User user = new User(agent);

        List<Ticket> boughtTickets = user.buyRandomTicketsUnderBudget(view.getBudgetByPrompt());
        view.showBoughtTickets(boughtTickets);

        agent.setResult(view.getResultNumbersByPrompt(), view.getResultBonusBallByPrompt());

        view.showReport(user.getReport());
    }
}
