package controller;

import domain.LottoTickets;
import view.dto.LottoPurchaseResponse;
import controller.dto.WinningResult;
import common.model.LottoRank;
import domain.model.ticket.WinningLottoTicket;
import domain.LottoGameService;
import view.LottoGameView;
import view.dto.LottoPurchaseRequest;
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
     * 2. 수동 로또 입력받기
     * 3. 로또 복권 구매하기
     * 4. 당첨 번호 입력받기
     * 5. 보너스 볼 입력받기
     * 6. 당첨 결과 출력하기
     */
    public void run() throws IOException {
        int amount = lottoGameView.queryPurchaseAmount();
        validatePurchaseAmount(amount);

        int manualLottoCount = lottoGameView.queryManualLottoCount();
        validateManualLottoCount(manualLottoCount);

        List<List<Integer>> manualLottoTickets = lottoGameView.queryManualLottoNumbers(manualLottoCount);
        LottoTickets lottoTickets = lottoGame.purchase(new LottoPurchaseRequest(amount, manualLottoCount, manualLottoTickets));
        lottoGameView.printLottoTickets(makeLottoPurchaseResponse(lottoTickets, manualLottoCount));

        List<Integer> winningLottoNumbers = lottoGameView.queryWinningLotto();
        int bonusNumber = lottoGameView.queryBonusNumber();

        WinningResult winningResult = lottoGame.checkWinningLotto(lottoTickets, new WinningLottoTicket(winningLottoNumbers, bonusNumber));
        lottoGameView.printLottoResults(makeWinningResultResponse(winningResult, amount));
    }

    private void validatePurchaseAmount(int amount) {
        if(amount < 0) { throw new IllegalArgumentException("구입 금액은 0이상 입력해야합니다."); }
    }

    private void validateManualLottoCount(int count) {
        if(count < 0) { throw new IllegalArgumentException("수동 구매 수는 0이상의 수만 가능합니다."); }
    }

    private WinningResultResponse makeWinningResultResponse(WinningResult winningResult, int amount) {
        Map<LottoRank, Integer> countMap = winningResult.getCountMap();
        List<WinningStatisticalData> statDataList = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getWinningCount() != 0)
                .map(rank -> new WinningStatisticalData(rank.getWinningCount(), rank.isNeedBonus(), rank.getWinnings(), countMap.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
        return new WinningResultResponse(statDataList, winningResult.getProfitRatio());
    }

    private LottoPurchaseResponse makeLottoPurchaseResponse(LottoTickets lottoTickets, int manualLottoCount) {
        return new LottoPurchaseResponse(lottoTickets, manualLottoCount);
    }

}
