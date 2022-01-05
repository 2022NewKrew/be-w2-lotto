import domain.*;
import view.OutputView;
import view.InputView;

import java.util.*;


public class main {
    private static int playerMoney;
    private static int payManualCount;
    private static int payAutoCount;
    public static final int LOTTO_PRICE = 1000;
    private static Player player;
    private static Matching matching = new Matching();

    public static void main(String[] args) {
        playerMoney = InputView.getPayPriceInput();
        payManualCount = InputView.getManualCountInput(playerMoney/LOTTO_PRICE);
        payAutoCount = (playerMoney - payManualCount*LOTTO_PRICE) / LOTTO_PRICE;

        List<Lotto> manualLottoList  = InputView.getManualLottoInput(payManualCount);

        player = new Player(payAutoCount, manualLottoList);
        OutputView.printLottoList(player);
        OutputView.PrintLottoSize(payAutoCount, payManualCount);

        matching.addMatchingLotto(player);

        OutputView.printMatchResult(matching, playerMoney);
    }

}