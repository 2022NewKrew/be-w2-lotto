package lotto.service;

import lotto.service.domain.*;
import lotto.util.LottoConstantValue;

import java.util.*;

public class LottoService {

    public LottoGame purchaseLottoGame(long budget){
        long gameCount = budget / LottoConstantValue.LOTTO_PRICE;
        LottoGame lottoGame = new LottoGame(autoPurchaseTickets((int)gameCount));
        return lottoGame;
    }

    public LottoGame purchaseLottoGame(long budget, List<List<Integer>> manualNumbersList){
        long gameCount = budget / LottoConstantValue.LOTTO_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();
        for(List<Integer> manualNumbers : manualNumbersList){
            gameCount--;
            LottoNumbers lottoNumbers = new LottoNumbers(manualNumbers);
            tickets.add(new LottoTicket(lottoNumbers));
        }
        tickets.addAll(autoPurchaseTickets((int)gameCount));
        return new LottoGame(tickets);
    }

    private List<LottoTicket> autoPurchaseTickets(int gameCount){
        List<LottoTicket> tickets = new ArrayList<>();
        for(int i = 0 ;i < gameCount; ++i){
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    public LottoResult getWholeGameResult(LottoGame lottoGame){
        Map<LottoPrizeDetails, Integer> wholeGameResult = new HashMap<>();

        lottoGame.getLottoTickets().forEach(ticket -> {
            wholeGameResult.putIfAbsent(ticket.getPrizeDetails(), 0);
            wholeGameResult.computeIfPresent(ticket.getPrizeDetails(), (LottoPrizeDetails prizeDetails, Integer count) -> ++count);
        });

        long wholePrize = getWholePrize(lottoGame);
        double yield = getGameYield(lottoGame.getLottoTickets().size(), wholePrize);
        return new LottoResult(wholeGameResult, yield);
    }

    private long getWholePrize(LottoGame lottoGame){
        final long wholePrize = lottoGame.getLottoTickets().stream().mapToLong(LottoTicket::getPrizeMoney).sum();
        return wholePrize;
    }

    private double getGameYield(int gameCount, long wholePrize){
        final double purchasedMoney = ((long)gameCount)*LottoConstantValue.LOTTO_PRICE;
        final double yield = (double) (wholePrize - purchasedMoney) / (double) purchasedMoney * 100;
        return yield;
    }

}
