package lotto.domain;

import lotto.view.InputUtils;

import java.util.List;
import java.util.Map;

public class LotteryGameManager {
    private LotteryGame purchaseTickets() {
        int numTickets = InputUtils.getNumTickets();
        int numManualTickets = InputUtils.getNumManualTickets(numTickets);
        List<Ticket> manualTickets= InputUtils.getManualTickets(numManualTickets);
        LotteryGame game = new LotteryGame(manualTickets, numTickets);
        InputUtils.printTickets(game);
        return game;
    }

    private void getLotteryResult(LotteryGame game) {
        List<Integer> winningNumber = InputUtils.getWinningNumber();
        int bonusNumber = InputUtils.getBonusNumber();
        WinningTicket winningTicket = new WinningTicket(winningNumber, bonusNumber);

        Map<Integer, Integer> gameResult = game.getResult(winningTicket);
        InputUtils.printResult(gameResult, game.numTickets);
    }

    public void run() {
        LotteryGame game = purchaseTickets();
        getLotteryResult(game);
    }
}
