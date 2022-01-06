import domain.*;
import view.OutputView;
import view.InputView;

import java.util.*;


public class main {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int playerMoney = InputView.getPayPriceInput();
        int payManualCount = InputView.getManualCountInput(playerMoney/LOTTO_PRICE);
        int payAutoCount = (playerMoney - payManualCount*LOTTO_PRICE) / LOTTO_PRICE;

        List<Lotto> manualLottoList  = InputView.getManualLottoInput(payManualCount);

        Player player = new Player(payAutoCount, manualLottoList);
        OutputView.printLottoList(player);
        OutputView.printLottoSize(payAutoCount, payManualCount);

        Matching matching = new Matching();
        matching.addMatchingLotto(player);

        OutputView.printMatchResult(matching, playerMoney);
    }

}