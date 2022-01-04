package domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class LottoResult {
    private final LottoList lottoList;
    private final Lotto resultLottoNumber;
    private final int resultBonusNumber;
    private final Map<Rank, Integer> lottoResult;

    public LottoResult(LottoList lottoList, Lotto resultLottoNumber, int resultBonusNumber) {
        this.lottoList = lottoList;
        this.resultLottoNumber = resultLottoNumber;
        this.resultBonusNumber = resultBonusNumber;
        lottoResult = new TreeMap<>(Collections.reverseOrder());

        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getLottoResult(){
        for (Lotto lotto : lottoList.getLottoList()) {
            Rank rank = Rank.valueOf(matchLotto(lotto), checkBonusLotto(lotto));
            lottoResult.put(rank, lottoResult.get(rank)+1);
        }

        return lottoResult;
    }

    public Double getTotalResultPrice(){
        AtomicLong resultPrice = new AtomicLong(0L);
        long purchasePrice = lottoList.getLottoPrice();

        lottoResult.forEach((rank, count) ->
                resultPrice.addAndGet((long) rank.getWinningMoney() * count));

        return (double) resultPrice.get() / purchasePrice * 100;
    }


    private int matchLotto(Lotto purchaseLotto){
        int count = 0;
        for (Integer lottoNumber : purchaseLotto.getLotto()) {
            count += resultLottoNumber.getLotto().contains(lottoNumber) ? 1 : 0;
        }

        return count;
    }

    private boolean checkBonusLotto(Lotto purchaseLotto){
        return purchaseLotto.getLotto().contains(resultBonusNumber);
    }

}
