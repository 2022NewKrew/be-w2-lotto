package lotto;

import lotto.domain.LottoGame;
import lotto.view.View;

public class LottoApplication {

    public static void main(String[] args) {
        try {
            View view = new View();
            LottoGame lottoGame = new LottoGame(view);
            lottoGame.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
