package lotto.domain;

import lotto.collections.LottoLine;
import lotto.collections.AnsLottoLine;
import lotto.dto.LottoResults;
import lotto.utils.LottoNumberPool;
import lotto.utils.Rank;
import lotto.collections.RankMap;

import java.util.ArrayList;
import java.util.List;

public class LottoPack {
    private final List<LottoLine> lottos = new ArrayList<>();
    private static final int LOTTO_PRICE = 1000;

    public LottoPack(int nLottos) {
        for(int i=0; i<nLottos;i++){
            LottoLine lottoLine = LottoNumberPool.getRandLotto();
            lottos.add(lottoLine);
        }
    }

    public List<LottoLine> getNumList() {
        return this.lottos;
    }

    public LottoResults getResults(AnsLottoLine ansLottoLine) {
        RankMap rankMap = new RankMap();

        for(LottoLine line : this.lottos){
            Rank rank = ansLottoLine.countMatch(line);
            rankMap.addCnt(rank);
        }
        int earnRate = this.getEarnRate(rankMap);
        return new LottoResults(rankMap, earnRate);
    }

    private int getEarnRate(RankMap rankMap){
        int numLottos = this.lottos.size();
        int price = 0;

        for(Rank rank: rankMap.getKeySet()){
            int tempPrice = rank.getWinningMoney();
            price += tempPrice * rankMap.getValue(rank);
        }

        return 100*price/(numLottos*LottoPack.LOTTO_PRICE);

    }



}
