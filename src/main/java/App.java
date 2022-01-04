import domain.Admin;
import domain.User;
import domain.lottery.Ticket;
import view.View;

import java.util.List;

public class App {
    public static void main(String[] args) {
        View view = new View();
        Admin admin = new Admin();
        User user = new User(admin);

        List<Ticket> boughtTickets = user.buyRandomTicketsUnderBudget(view.getBudgetByPrompt());
        view.showBoughtTickets(boughtTickets);

        admin.setResult(view.getResultNumbersByPrompt(), view.getResultBonusBallByPrompt());

        view.showReport(admin.getReportFor(user));
    }
}
