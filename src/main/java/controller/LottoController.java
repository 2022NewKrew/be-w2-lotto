package controller;

import model.*;
import util.Util;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final int LOTTO_PRICE = 1000;

    public LottoController() {
    }

    public void run() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        // 구매 총액, 수동 구매 수 입력
        int purchaseAmount = InputView.readPurchaseAmount();
        int totalLottoCount = purchaseAmount / LOTTO_PRICE;
        int manualLottoCount = InputView.readManualLottoCount(totalLottoCount);

        // 수동 구매 번호 입력, lotto 생성
        Lottos lottos = new Lottos(totalLottoCount-manualLottoCount, manualLottoCount);
        List<List<Integer>> manualLottos = InputView.readManualLottoNumbers(manualLottoCount);
        lottos.addAll(lottoGenerator.createManualLotto(manualLottos));
        lottos.addAll(lottoGenerator.createAutoLotto(totalLottoCount - manualLottoCount));
        OutputView.printLottos(lottos);

        // 지난 주 당첨 번호 입력, 보너스 볼 입력
        List<LottoNumber> lastWeeksWinningNumber = Util.convertIntegerListToLottoList(InputView.readLastWeeksWinningNumber());
        WinningNumber winningNumber = new WinningNumber(lastWeeksWinningNumber,InputView.readBonusNumber());

        // 최종 결과 집계
        RankResult rankResults = new RankResult();
        rankResults.calculateRankResults(winningNumber, lottos);
        long totalWinningAmount = LottoResult.calculateTotalWinningAmount(rankResults);
        long yield = LottoResult.calculateYield(totalWinningAmount,purchaseAmount);

        // 당첨 통계 출력
        OutputView.printLottoWinningStats(rankResults);
        OutputView.printLottoYield(yield);
    }
}