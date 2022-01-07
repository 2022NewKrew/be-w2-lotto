package com.cold.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class SingleTicket {
    private Integer CHECK_BONUS_BALL_MATCHES_COUNT = 5;

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
        this.bonusMatch = false;
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
            setBonusMatch(winningLotto.getBonusBall(), count);
        }
        return count;
    }

    private void setBonusMatch(Integer bonusBall, int count) {
        if (numbers.contains(bonusBall)) {
            this.bonusMatch = true;
        }
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
