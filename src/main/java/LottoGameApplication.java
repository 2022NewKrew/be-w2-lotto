import lotto.controller.LottoGame;
import lotto.domain.LottoMachine;
import lotto.view.LottoGameView;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoGame lottoGame = LottoGame.of(LottoMachine.create(), LottoGameView.create());
        lottoGame.run();
    }
}
