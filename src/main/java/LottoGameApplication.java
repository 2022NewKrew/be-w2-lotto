import lotto.controller.LottoGame;
import lotto.domain.LottoMachine;
import lotto.view.LottoGameView;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoMachine(),
            new LottoGameView());
        lottoGame.run();
    }
}
