import controller.LottoGameController;

public class LottoGame {

    public static void main(String[] args) {
        LottoGameController game = new LottoGameController();
        game.initialize();
        game.start();
    }
}
