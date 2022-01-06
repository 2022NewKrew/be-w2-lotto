import controller.LotteryController;
import domain.Buyer;
import domain.LotteryCentral;

public class Lottery {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        LotteryCentral lotteryCentral = new LotteryCentral();
        LotteryController controller = new LotteryController(buyer, lotteryCentral);
        controller.releaseTicketsToBuyer();
        controller.showTickets();
        controller.requireWinningTicketInfo();
        controller.makeBuyerToCalculate();
        controller.showStatistics();
    }
}
