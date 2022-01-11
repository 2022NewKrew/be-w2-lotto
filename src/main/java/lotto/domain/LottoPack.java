package lotto.domain;

import lotto.collections.LottoNumber;
import lotto.dto.LottoResults;
import lotto.dto.MatchNum;
import lotto.utils.Rank;
import lotto.utils.RankMap;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoPack {
    private List<List<LottoNumber>> lottos = new ArrayList();
    private Lotto lotto = new Lotto();
    private static final int lottoPrice = 1000;

    public LottoPack(int nLottos) {
        for(int i=0; i<nLottos;i++){
            List<LottoNumber> lottoLine = lotto.getRandLotto();
            lottos.add(lottoLine);
        }
    }

    public List<List<LottoNumber>> getNumList() {
        return this.lottos;
    }

    public LottoResults getResults(MatchNum matchNum) {
        RankMap rankMap = new RankMap();

        for(List<LottoNumber> nums : this.lottos){
            Rank rank = lotto.countMatch(nums, matchNum);
            rankMap.addCnt(rank);
        }
        int earnRate = this.getEarnRate(rankMap);
        LottoResults lottoResults = new LottoResults(rankMap, earnRate);
        return lottoResults;
    }

    private int getEarnRate(RankMap rankMap){
        int numLottos = this.lottos.size();
        int price = 0;

        for(Rank rank: rankMap.getKeySet()){
            int tempPrice = rank.getWinningMoney();
            price += tempPrice * rankMap.getValue(rank);
        }

        return 100*price/(numLottos*this.lottoPrice);

    }



}
