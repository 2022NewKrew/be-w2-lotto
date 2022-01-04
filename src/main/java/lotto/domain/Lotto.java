package lotto.domain;

import lotto.dto.MatchNum;
import lotto.utils.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    private List<Integer> oneLotto = new ArrayList<>();

    public Lotto(){
    }

    public List<Integer> getRandLotto() {
        Collections.shuffle(range);
        this.oneLotto = new ArrayList<>(range.subList(0,6));
        return this.oneLotto;
    }

    //helper function for LottoPack.getResults()
    public Rank countMatch(List<Integer> nums, MatchNum matchNum){
        int cnt = 0;
        for (int i : matchNum.getPrevNums()){
            cnt += countMatchPerNum(nums, i);
        }
        //check bonus num is matched
        boolean bonusMatch = (countMatchPerNum(nums, matchNum.getBonusNum()) == 1);
        Rank rank = Rank.valueOf(cnt, bonusMatch);
        return rank;
    }

    private int countMatchPerNum(List<Integer> nums, int i) {
        int cnt = 0;
        if (nums.contains(i)) {
            cnt += 1;
        }
        return cnt;
    }

}
