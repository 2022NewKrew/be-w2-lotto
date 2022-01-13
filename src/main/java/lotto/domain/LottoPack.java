package lotto.domain;

import lotto.collections.LottoLine;
import lotto.collections.AnsLottoLine;
import lotto.dto.LottoResults;
import lotto.dto.InputLottoConfig;
import lotto.utils.LottoNumberPool;
import lotto.utils.Rank;
import lotto.collections.RankMap;

import java.util.List;
import java.util.Objects;

public class LottoPack {
    private final List<LottoLine> lottos;

    public static final int LOTTO_PRICE = 1000;

    public LottoPack(InputLottoConfig lottoConfig){
       int totalCnt = lottoConfig.getTotalLottoCnt();
       int manualCnt = lottoConfig.getManualLottoCnt();
       int autoCnt = totalCnt - manualCnt;

       lottos = lottoConfig.getLottoLines();
       makeAutoLottoPack(autoCnt);
    }


    private void makeAutoLottoPack(int nLottos) {
        for(int i=0; i<nLottos;i++){
            LottoLine lottoLine = LottoNumberPool.getRandLotto();
            lottos.add(lottoLine);
        }
    }

    public List<LottoLine> getLottos() {
        return this.lottos;
    }

    public LottoResults getResults(AnsLottoLine ansLottoLine) {
        RankMap rankMap = new RankMap();

        for(LottoLine line : this.lottos){
            Rank rank = ansLottoLine.countMatch(line);
            rankMap.addCnt(rank);
        }
        long earnRate = this.getEarnRate(rankMap);
        return new LottoResults(rankMap, earnRate);
    }

    private long getEarnRate(RankMap rankMap){
        int numLottos = this.lottos.size();
        long price = 0;

        for(Rank rank: rankMap.getKeySet()){
            int tempPrice = rank.getWinningMoney();
            price += (long) tempPrice * rankMap.getValue(rank);
        }

        return 100*price/((long) numLottos*LottoPack.LOTTO_PRICE);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoPack)) return false;
        LottoPack lottoPack = (LottoPack) o;
        return getLottos().equals(lottoPack.getLottos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottos());
    }
}
