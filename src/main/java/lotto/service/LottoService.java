package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningResult;
import lotto.utils.LottoTextConvertor;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

public class LottoService {

    private LottoTicket lottoTicketCache;

    public Map<Object, Object> buyLotto(Request request) {
        String inputMoney = request.queryParams("inputMoney");
        String manualNumberTexts = request.queryParams("manualNumber");

        LottoTicket lottoTicket = new LottoTicket(Integer.parseInt(inputMoney), LottoTextConvertor.convertManualNumberTextsToList(manualNumberTexts));

        Map<Object, Object> buyLottoResult = new HashMap<>();
        buyLottoResult.put("lottos", lottoTicket.getLottoList());
        buyLottoResult.put("lottosSize", lottoTicket.getLottoCount());

        lottoTicketCache = lottoTicket;

        return buyLottoResult;
    }

    public Map<Object, Object> matchLotto(Request request) {
        String winningNumberText = request.queryParams("winningNumber");
        int bonusNumber = Integer.parseInt(request.queryParams("bonusNumber"));

        LottoWinningResult lottoWinningResult = lottoTicketCache.getLottoWinningResult(LottoTextConvertor.convertWinningNumberTextToList(winningNumberText), bonusNumber);

        Map<Object, Object> matchLottoResult = new HashMap<>();
        matchLottoResult.put("lottosResult", lottoWinningResult);
        matchLottoResult.put("message", lottoWinningResult.getLottoWinningResultMessage());
        matchLottoResult.put("totalRateOfReturn", lottoWinningResult.getYield(lottoTicketCache.getWholeLottoPrice()));

        return matchLottoResult;
    }

}
