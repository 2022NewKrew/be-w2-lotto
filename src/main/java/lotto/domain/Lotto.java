package lotto.domain;

import lotto.dto.MatchNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    private static List<Integer> oneLotto = new ArrayList<>();

    public Lotto(){
    }

    public List<Integer> getRandLotto() {
        Collections.shuffle(range);
        oneLotto = new ArrayList<>(range.subList(0,6));
        return oneLotto;
    }

    //helper function for LottoPack.getResults()
    public int countMatch(List<Integer> nums, MatchNum matchNum){
        int cnt = 0;
        for (int i : matchNum.getPrevNums()){
            cnt += countMatchPerNum(nums, i);
        }
        if (cnt == 6){
            return 7;
        }
        //check bonus num is matched
        if( cnt == 5 && countMatchPerNum(nums, MatchNum.getBonusNum()) == 1){
            return 6;
        }
        return cnt;
    }

    private int countMatchPerNum(List<Integer> nums, int i) {
        int cnt = 0;
        if (nums.contains(i)) {
            cnt += 1;
        }
        return cnt;
    }

}
