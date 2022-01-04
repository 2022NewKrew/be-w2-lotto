package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class MatchNum {
    private List<Integer> prevNums = new ArrayList<>(6);
    private int bonusNum;

    public MatchNum(List<Integer> prevNums, int bonusNum) {
        this.prevNums = prevNums;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getPrevNums(){
        return this.prevNums;
    }
    public int getBonusNum(){
        return this.bonusNum;
    }
}
