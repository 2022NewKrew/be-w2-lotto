package lotto;

import lotto.domain.LottoGame;
import lotto.view.View;

public class LottoApplication {

    public static void main(String[] args) {
        View view = new View();
        LottoGame lottoGame = new LottoGame(view);
        lottoGame.run();
    }

}
