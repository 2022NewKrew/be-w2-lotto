package domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class LottoResult {
    private final LottoList lottoList;
    private final Lotto resultLotto;
    private final int resultBonusNumber;
    private final Map<Rank, Integer> lottoResultMap;

    public LottoResult(LottoList lottoList, Lotto resultLotto, int resultBonusNumber) {
        this.lottoList = lottoList;
        this.resultLotto = resultLotto;
        this.resultBonusNumber = resultBonusNumber;
        lottoResultMap = new TreeMap<>(Collections.reverseOrder());

        for (Rank rank : Rank.values()) {
            lottoResultMap.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getLottoResult(){
        for (Lotto lotto : lottoList.getLottoList()) {
            Rank rank = Rank.valueOf(matchLotto(lotto), checkBonusLotto(lotto));
            lottoResultMap.put(rank, lottoResultMap.get(rank)+1);
        }

        return lottoResultMap;
    }

    public Double getTotalResultPrice(){
        AtomicLong resultPrice = new AtomicLong(0L);
        long purchasePrice = (long) lottoList.getCount() * LottoConst.ONE_LOTTO_PRICE;

        lottoResultMap.forEach((rank, count) ->
                resultPrice.addAndGet((long) rank.getWinningMoney() * count));

        return (double) (resultPrice.get()-purchasePrice) / purchasePrice * 100;
    }


    private int matchLotto(Lotto purchaseLotto){
        Set<Integer> lottoSet = new HashSet<>(resultLotto.getLotto());

        int count = 0;
        for (Integer lottoNumber : purchaseLotto.getLotto()) {
            count += lottoSet.contains(lottoNumber) ? 1 : 0;
        }


        return count;
    }

    private boolean checkBonusLotto(Lotto purchaseLotto){
        return purchaseLotto.getLotto().contains(resultBonusNumber);
    }

}
