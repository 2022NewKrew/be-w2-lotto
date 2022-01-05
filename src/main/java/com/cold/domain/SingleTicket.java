package com.cold.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class SingleTicket {
    private Integer CHECK_BONUS_BALL_MATCHES_COUNT = 5;
    private Integer MAP_BONUS_MATCH_KEY = 7;

    private List<Integer> numbers;
    private Boolean bonusMatch;
    private Integer matches;

    public SingleTicket() {
        this.bonusMatch = false;
        List<Integer> wholeNumbers = createWholeNumbers();
        Collections.shuffle(wholeNumbers);
        this.numbers = wholeNumbers.subList(0, 6);
        Collections.sort(this.numbers);
    }

    public SingleTicket(List<Integer> numberSet) {
        bonusMatch = false;
        this.numbers = numberSet;
    }

    private List createWholeNumbers() {
        List<Integer> wholeNumbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            wholeNumbers.add(i + 1);
        }
        return wholeNumbers;
    }

    public void setMatches(WinningLotto winningLotto) {
        int count = countMatches(winningLotto);
        this.matches = count;
    }

    private int countMatches(WinningLotto winningLotto) {
        int count = countNormalMatches(winningLotto.getLastWinningNums());
        if (count == CHECK_BONUS_BALL_MATCHES_COUNT) {
            return checkBonusMatch(winningLotto.getBonusBall(), count);
        }
        return count;
    }

    private int checkBonusMatch(Integer bonusBall, int cnt) {
        if (numbers.contains(bonusBall)) {
            return MAP_BONUS_MATCH_KEY;
        }
        return cnt;
    }

    private int countNormalMatches(List<Integer> lastWinningNums) {
        int cnt = 0;
        for (Integer num : numbers) {
            cnt += checkEachNum(num, lastWinningNums);
        }
        return cnt;
    }

    private int checkEachNum(Integer num, List<Integer> lastWinningNums) {
        return lastWinningNums.contains(num) ? 1 : 0;
    }
}
