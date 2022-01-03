package lotto.domain;

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
    public int countMatch(List<Integer> nums, List<Integer> prevNums){
        int cnt = 0;
        for (int i : prevNums){
            cnt += countMatchPerNum(nums, i);
        }
        return cnt;
    }

    private int countMatchPerNum(List<Integer> nums, int i){
        int cnt = 0;
        if (nums.contains(i)){
            cnt +=1;
        }
        return cnt;
    }

}
