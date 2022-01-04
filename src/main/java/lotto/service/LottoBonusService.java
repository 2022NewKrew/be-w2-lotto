package lotto.service;

import lotto.service.domain.LottoGame;
import lotto.service.domain.LottoPrizeDetails;
import lotto.service.domain.LottoResult;
import lotto.service.domain.LottoTicket;
import lotto.util.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoBonusService extends LottoService {

    public LottoResult getWholeGameResult(LottoGame lottoGame, List<Integer> winningNumbers, int bonusNumber){
        long wholePrizeMoney = getWholePrize(lottoGame, winningNumbers, bonusNumber);
        Map<LottoPrizeDetails, Integer> wholeGameResult = new HashMap<>();
        mapInit(wholeGameResult);

        for(LottoTicket ticket : lottoGame.getLottoTickets()){
            LottoPrizeDetails key = ticket.getPrizeDetails();
            if(key == LottoPrizeDetails.NO_PRIZE || key == LottoPrizeDetails.UNIDENTIFIED) continue;
            if(!wholeGameResult.containsKey(key))
                wholeGameResult.put(key, 1);
            else
                wholeGameResult.put(key, wholeGameResult.get(key)+1);
        }
        return new LottoResult(wholeGameResult, wholePrizeMoney);
    }
    protected void mapInit(Map<LottoPrizeDetails, Integer> map){
        super.mapInit(map);
        map.put(LottoPrizeDetails.SECOND_PRIZE, 0);
    }

    private long getWholePrize(LottoGame lottoGame, List<Integer> winningNumbers, int bonusNumber){
        Validator.checkLottoNumbersFormat(winningNumbers);

        long wholePrize = 0;
        for(LottoTicket ticket : lottoGame.getLottoTickets()){
            if(ticket.getPrizeDetails() == LottoPrizeDetails.UNIDENTIFIED)
                ticket.setPrizeDetails(findPrizeDetails(ticket,winningNumbers, bonusNumber));
            wholePrize += ticket.getPrizeMoney();
        }
        return wholePrize;
    }

    private LottoPrizeDetails findPrizeDetails(LottoTicket ticket, List<Integer> winningNumbers, int bonusNumber) {
        LottoPrizeDetails prizeDetails = super.findPrizeDetails(ticket, winningNumbers);
        if(prizeDetails == LottoPrizeDetails.THIRD_PRIZE && containBonusNumber(ticket, bonusNumber))
            prizeDetails = LottoPrizeDetails.SECOND_PRIZE;

        return prizeDetails;
    }
    private boolean containBonusNumber(LottoTicket ticket, int bonusNumber){
        return ticket.getLottoNumbers().getNumbers().contains(bonusNumber);
    }
}
