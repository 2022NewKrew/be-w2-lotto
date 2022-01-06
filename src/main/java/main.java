import domain.*;
import view.OutputView;
import view.InputView;

import java.util.*;


public class main {


    public static void main(String[] args) {
        int playerMoney = InputView.getPayPriceInput();

        Player player = new Player(playerMoney);
        OutputView.printLottoList(player);
        OutputView.printLottoSize(player.getPayAutoCount(), player.getPayManualCount());

        Matching matching = new Matching();
        matching.addMatchingLotto(player);

        OutputView.printMatchResult(matching, playerMoney);
    }

}