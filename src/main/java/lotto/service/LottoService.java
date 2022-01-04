package lotto.service;

import lotto.service.domain.LottoGame;
import lotto.service.domain.LottoPrizeDetails;
import lotto.service.domain.LottoResult;
import lotto.service.domain.LottoTicket;
import lotto.util.LottoConstantValue;
import lotto.util.Validator;

import java.util.*;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService() {
        lottoGenerator = new LottoGenerator();
    }

    public LottoGame purchaseLottoGame(long budget){
        LottoGame lottoGame = new LottoGame(generateLottoTickets(budget));
        printPurchaseHistory(lottoGame);
        return lottoGame;
    }

    private List<LottoTicket> generateLottoTickets(long budget){
        long gameCount = budget / LottoConstantValue.LOTTO_PRICE;
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for(int i = 0; i < gameCount; ++i){
            LottoTicket ticket = new LottoTicket(lottoGenerator.autoGenerate());
            lottoTickets.add(ticket);
        }
        return lottoTickets;
    }
    private void printPurchaseHistory(LottoGame lottoGame){
        System.out.println(lottoGame.getLottoTickets().size() + "개를 구매했습니다.");
        lottoGame.getLottoTickets().stream().forEach(LottoTicket::print);
    }

    public LottoResult getWholeGameResult(LottoGame lottoGame, List<Integer> winningNumbers){
        long wholePrizeMoney = getWholePrize(lottoGame, winningNumbers);
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
        map.put(LottoPrizeDetails.FIRST_PRIZE, 0);
        map.put(LottoPrizeDetails.THIRD_PRIZE, 0);
        map.put(LottoPrizeDetails.FOURTH_PRIZE, 0);
        map.put(LottoPrizeDetails.FIFTH_PRIZE, 0);
    }

    protected long getWholePrize(LottoGame lottoGame, List<Integer> winningNumbers){
        Validator.checkLottoNumbersFormat(winningNumbers);

        long wholePrize = 0;
        for(LottoTicket ticket : lottoGame.getLottoTickets()){
            if(ticket.getPrizeDetails() == LottoPrizeDetails.UNIDENTIFIED)
                ticket.setPrizeDetails(findPrizeDetails(ticket, winningNumbers));
            wholePrize += ticket.getPrizeMoney();
        }
        return wholePrize;
    }

    protected LottoPrizeDetails findPrizeDetails(LottoTicket ticket, List<Integer> winningNumbers){
        int score = getLottoScore(ticket, winningNumbers);
        if(score >= 6)
            return LottoPrizeDetails.FIRST_PRIZE;
        else if(score == 5)
            return LottoPrizeDetails.THIRD_PRIZE;
        else if(score == 4)
            return LottoPrizeDetails.FOURTH_PRIZE;
        else if(score == 3)
            return LottoPrizeDetails.FIFTH_PRIZE;
        return LottoPrizeDetails.NO_PRIZE;
    }
    protected int getLottoScore(LottoTicket ticket, List<Integer> winningNumbers){
        return (int)winningNumbers.stream().filter(ticket.getLottoNumbers().getNumbers()::contains).count();
    }


}
