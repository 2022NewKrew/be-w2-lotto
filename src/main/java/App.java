import domain.Purchase;
import domain.lottery.Tickets;
import view.View;

public class App {
    public static void main(String[] args) {
        final int TICKET_PRICE = 1000;

        View view = new View();
        Purchase purchase = new Purchase(TICKET_PRICE);

        Tickets boughtTickets = purchase.buyRandomTicketsUnderBudget(view.getBudgetByPrompt());
        view.showBoughtTickets(boughtTickets);

        purchase.setResult(view.getResultNumbersByPrompt(), view.getResultBonusBallByPrompt());

        view.showReport(purchase.getReport());
    }
}
