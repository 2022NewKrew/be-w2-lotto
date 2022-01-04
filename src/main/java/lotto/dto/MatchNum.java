package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class MatchNum {
    private static List<Integer> prevNums = new ArrayList<>(6);
    private static int bonusNum;

    public MatchNum(List<Integer> prevNums, int bonusNum) {
        this.prevNums = prevNums;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getPrevNums(){
        return prevNums;
    }
    public static int getBonusNum(){
        return bonusNum;
    }
}
