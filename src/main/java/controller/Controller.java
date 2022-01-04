package controller;

import domain.Calculator;
import domain.Lotto;
import domain.Winning;
import view.InputInfos;
import view.Outputs;
import java.util.List;

public class Controller {
    public static void initLottoGame() {
        InputInfos inputInfos = new InputInfos();
        Outputs outputs = new Outputs();
        Calculator calculator = new Calculator();
        Lotto lotto = new Lotto();
        Winning winning = new Winning();
        int money = inputInfos.buyingInfo();
        int lottoCnt = lotto.getLottoCnt(money);// 몇개의 로또 티켓을 살지 받아옴
        outputs.printBuyingResult(lottoCnt);
        List<List> lottoTickets = lotto.getLottoTickets(lottoCnt);
        outputs.printHavingTickets(lottoTickets);
        List<Integer> lastWinningNumbers = inputInfos.inputLastWinningNumbers();
        List<Integer> rankCountList = calculator.getRankCountList(lottoTickets, lastWinningNumbers);
        outputs.printResultStart();
        winning.showWinningTickets(rankCountList);
        winning.getEarningRate(rankCountList);
    }
}
