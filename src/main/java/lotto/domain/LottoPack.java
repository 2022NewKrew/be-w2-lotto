package lotto.domain;

import lotto.dto.LottoResults;
import lotto.dto.MatchNum;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPack {
    private List<List<Integer>> lottos = new ArrayList();
    private Lotto lotto = new Lotto();
    private static final List<Integer> priceList = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);
    private static final int lottoPrice = 1000;

    public LottoPack(int nLottos) {
        for(int i=0; i<nLottos;i++){
            List<Integer> lottoNums = lotto.getRandLotto();
            lottos.add(lottoNums);
        }
    }

    public List<List<Integer>> getNumList() {
        return this.lottos;
    }

    public LottoResults getResults(MatchNum matchNum) {
        List<Integer> correctCnts = Arrays.asList(0,0,0,0,0);

        for(List<Integer> nums : this.lottos){
            int cnt = lotto.countMatch(nums, matchNum);
            this.addCnt(correctCnts, cnt);
        }
        int earnRate = this.getEarnRate(correctCnts);
        LottoResults lottoResults = new LottoResults(correctCnts, earnRate);
        return lottoResults;
    }

    private int getEarnRate(List<Integer> correctCnts){
        int numLottos = this.lottos.size();
        int price = 0;
        int idx = 0;

        for(int cnt: correctCnts){
            int tempPrice = this.priceList.get(idx);
            price += tempPrice * cnt;
            idx +=1;
        }

        return 100*price/(numLottos*this.lottoPrice);

    }

    //helper function for getResults()
    private void addCnt(List<Integer> correctCnts, int idx){
        if (idx <3){
            return;
        }
        idx = idx -3; // start index from 3
        int value = correctCnts.get(idx);
        correctCnts.set(idx, value +1);
    }



}
