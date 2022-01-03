package domain;

import domain.Lotto;
import domain.LottoConst;
import domain.LottoList;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final LottoList lottoList;
    private final Map<Integer, Integer> lottoResult;

    public LottoResult(LottoList lottoList) {
        this.lottoList = lottoList;
        lottoResult = new HashMap<>();

        for(int i=0; i<=6; i++){
            lottoResult.put(i, 0);
        }
    }

    public Map<Integer, Integer> getLottoResult(Lotto resultNumber){
        for (Lotto lotto : lottoList.getLottoList()) {
            int matchCount = matchLotto(lotto, resultNumber);
            lottoResult.put(matchCount, lottoResult.get(matchCount)+1);
        }

        return lottoResult;
    }

    public Double getTotalResultPrice(){
        long resultPrice = 0L;
        long purchasePrice = (long) LottoConst.LOTTO_PRICE * lottoList.getLottoList().size();

        for (Integer rank : LottoConst.RANK_TO_PRICE.keySet()) {
            resultPrice += (long) LottoConst.RANK_TO_PRICE.get(rank) * lottoResult.get(rank);
        }

        return (double) resultPrice / purchasePrice * 100;
    }


    private int matchLotto(Lotto purchaseNumber, Lotto resultNumber){
        int count = 0;
        for (Integer lottoNumber : purchaseNumber.getLotto()) {
            count += resultNumber.getLotto().contains(lottoNumber) ? 1 : 0;
        }

        return count;
    }

}
