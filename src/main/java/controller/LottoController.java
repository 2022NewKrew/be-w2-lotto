package controller;

import controller.dto.WinningResult;
import domain.LottoTickets;
import common.model.LottoRank;
import domain.model.WinningLottoTicket;
import domain.LottoGameService;
import view.LottoGameView;
import view.dto.WinningResultResponse;
import view.model.WinningStatisticalData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private static LottoGameView lottoGameView = new LottoGameView();

    private static LottoGameService lottoGame = new LottoGameService();

    /**
     * 1. 구매 금액 입력받기
     * 2. 로또 복권 구매하기
     * 3. 당첨 번호 입력받기
     * 4. 보너스 볼 입력받기
     * 5. 당첨 결과 출력하기
     */
    public void run() throws IOException {
        int amount = lottoGameView.queryPurchaseAmount();
        LottoTickets lottoTickets = lottoGame.purchase(amount);
        lottoGameView.printLottoTickets(lottoTickets);

        List<Integer> winningLottoNumbers = lottoGameView.queryWinningLotto();
        int bonusNumber = lottoGameView.queryBonusNumber();

        WinningResult winningResult = lottoGame.checkWinningLotto(
                lottoTickets, new WinningLottoTicket(winningLottoNumbers, bonusNumber));
        lottoGameView.printLottoResults(makeWinningResultResponse(winningResult, amount));
    }

    private WinningResultResponse makeWinningResultResponse(WinningResult winningResult, int amount) {
        Map<LottoRank, Integer> countMap = winningResult.getCountMap();
        List<WinningStatisticalData> statDataList = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getWinningCount() != 0)
                .map(rank -> new WinningStatisticalData(rank.getWinningCount(), rank.isNeedBonus(), rank.getWinnings(), countMap.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
        return new WinningResultResponse(statDataList, winningResult.getProfitRatio());
    }


}
