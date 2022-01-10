import lottogame.controller.LottoGameController;
import lottogame.view.LottoGameView;

public class StartLottoGame {
    public static void main(String[] args) {
        new LottoGameController(new LottoGameView()).run();
    }
}
