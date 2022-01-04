package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class WinningLotto {

    // 당첨번호
    private final List<Integer> winningLotto;
    // 보너스 번호
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
