package controller;

import domain.Lotto;
import domain.Matching;
import domain.Player;
import dto.LottosResult;
import view.ConsoleInputView;
import view.ConsoleOutputView;

import java.util.List;

import static domain.Player.LOTTO_PRICE;

public class ConsoleController {

    public void run()
    {
        int playerMoney = ConsoleInputView.getPayPriceInput();
        int payManualCount = ConsoleInputView.getManualCountInput(playerMoney/LOTTO_PRICE);
        List<Lotto> manualLottoList = ConsoleInputView.getManualLottoInput(payManualCount);
        Player player = new Player(playerMoney, manualLottoList);
        ConsoleOutputView.printLottoPlayer(player);

        Matching matching = new Matching();
        matching.addMatchingLotto(player, ConsoleInputView.getWinningInput(), ConsoleInputView.getBonusWinningInput());

        LottosResult lottosResult = new LottosResult(matching, player);
        ConsoleOutputView.printMatchResult(lottosResult);
    }
}
