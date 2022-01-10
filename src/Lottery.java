import controller.LotteryController;
import domain.Buyer;
import domain.LotteryCentral;
import view.View;

public class Lottery {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        LotteryCentral lotteryCentral = new LotteryCentral();
        View view = new View();

        LotteryController controller = new LotteryController(buyer, lotteryCentral, view);
        controller.serveTicketsToBuyer();
        controller.showTickets();
        controller.drawLottery();
        controller.makeBuyerToCalculate();
        controller.showStatistics();
    }
}
