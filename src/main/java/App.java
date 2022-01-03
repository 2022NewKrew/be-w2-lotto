import domain.Admin;
import domain.User;
import domain.lottery.Ticket;
import view.View;

import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        View view = new View();
        User user = new User();
        Admin admin = new Admin();

        List<Ticket> boughtTickets = user.buyRandomTicketsUnderBudget(view.getBudgetByPrompt(), new Random());
        view.showBoughtTickets(boughtTickets);

        admin.setResult(view.getResultNumbersByPrompt());

        view.showReport(admin.getReportFor(user));
    }
}
