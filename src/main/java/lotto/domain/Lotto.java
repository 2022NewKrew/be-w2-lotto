package lotto.domain;

import lotto.collections.LottoNumber;
import lotto.dto.MatchNum;
import lotto.utils.LottoNumberPool;
import lotto.utils.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {


    public List<LottoNumber> getRandLotto() {
        Collections.shuffle(LottoNumberPool.NumberPool);
        List<LottoNumber> oneLotto = new ArrayList<>(LottoNumberPool.NumberPool.subList(0,6));
        return oneLotto;
    }

    //helper function for LottoPack.getResults()
    public Rank countMatch(List<LottoNumber> nums, MatchNum matchNum){
        int cnt = 0;
        for (int i : matchNum.getPrevNums()){
            cnt += countMatchPerNum(nums, i);
        }
        //check bonus num is matched
        boolean bonusMatch = (countMatchPerNum(nums, matchNum.getBonusNum()) == 1);
        Rank rank = Rank.valueOf(cnt, bonusMatch);
        return rank;
    }

    private int countMatchPerNum(List<LottoNumber> nums, int i) {
        int cnt = 0;
        if (nums.contains(i)) {
            cnt += 1;
        }
        return cnt;
    }

}
