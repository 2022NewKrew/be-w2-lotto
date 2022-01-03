package com.cold;

import com.cold.domain.GameLogic;
import com.cold.domain.WholeTickets;
import com.cold.view.InputView;
import com.cold.view.OutputView;

//로또 번호 1~45 중 6개의 숫자
public class Lotto {
  public static void main(String[] args) throws Exception{
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    WholeTickets wholeTickets = new WholeTickets();
    GameLogic gameLogic = new GameLogic();

    int purchasedCount = inputView.Purchase();

    wholeTickets.purchaseTickets(purchasedCount);

    outputView.printPurchaseResult(wholeTickets, purchasedCount);

    String lastWinningNums = inputView.inputLastWinningNums();
    gameLogic.parseLastWinningNums(lastWinningNums);
    gameLogic.calculateResult(wholeTickets);

    outputView.printGameResult(gameLogic.getResult());
  }
}
