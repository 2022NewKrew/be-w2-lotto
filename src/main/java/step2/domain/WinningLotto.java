package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class WinningLotto {

    private final List<Integer> winningLotto;

    public WinningLotto(List<Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }
}
