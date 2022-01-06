package step4;

import step4.input.ConsoleInput;
import step4.service.LottoService;
import step4.service.domain.LottoBundle;
import step4.service.domain.WinningLotto;
import step4.util.LottoUtil;
import step4.view.ConsoleView;
import step4.view.View;
import step4.view.dto.LottoGameResult;

import java.util.List;
import java.util.Map;

public class LottoGameConsole implements LottoGame {
    private ConsoleInput input = new ConsoleInput();
    private LottoService lottoService;
    private View view = new ConsoleView();

    public LottoGameConsole(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @Override
    public void run() {
        LottoBundle lottoTickets = inputGameInfo();
        showTickets(lottoTickets);

        WinningLotto winningLotto = createWinningLotto();
        Map<Integer, Integer> results = lottoService.matchAndGetResult(lottoTickets, winningLotto);
        double profitRate = lottoService.calculateProfitRate(lottoTickets.getTicketAmount(), results);
        String plainFormatOfProfit = LottoUtil.removeExp(profitRate);

        LottoGameResult lottoGameResult = new LottoGameResult(results, plainFormatOfProfit);
        Map resultModel = LottoUtil.createResultModel(lottoGameResult);
        view.showResult(resultModel);
    }

    private void showTickets(LottoBundle lottoTickets) {
        Map showPageModel = LottoUtil.createShowPageModel(lottoTickets);
        view.showTickets(showPageModel);
    }

    private LottoBundle inputGameInfo() {
        int buyAmount = input.inputBuyTicketAmount();
        LottoBundle lottoTickets = buyLotto(buyAmount);

        return lottoTickets;
    }


    private LottoBundle buyLotto(int buyAmount) {
        int manualTicketAmount = input.inputAmoundOfSelf(buyAmount);
        List<List<Integer>> numbers = input.inputSelfNums(manualTicketAmount);
        return lottoService.buy(buyAmount, numbers);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> numbers = input.inputWinningNum();
        int bonusNum = input.inputBonusNum();
        return new WinningLotto(numbers, bonusNum);
    }
}
