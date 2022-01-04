package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNum;

    public WinningLotto(List<Integer> winningLotto, int bonusNum) {
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
