import domain.Lotto;
import service.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
