import domain.Agent;
import domain.Purchase;
import domain.lottery.Tickets;
import view.View;

public class App {
    public static void main(String[] args) {
        final int TICKET_PRICE = 1000;

        View view = new View();
        Agent agent = new Agent();
        Purchase purchase = new Purchase(agent, TICKET_PRICE);

        Tickets boughtTickets = purchase.buyRandomTicketsUnderBudget(view.getBudgetByPrompt());
        view.showBoughtTickets(boughtTickets);

        agent.setResult(view.getResultNumbersByPrompt(), view.getResultBonusBallByPrompt());

        view.showReport(purchase.getReport());
    }
}
