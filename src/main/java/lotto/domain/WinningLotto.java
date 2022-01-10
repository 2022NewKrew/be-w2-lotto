package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.LottoGame;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningLotto, int bonusNumber) {
        final HashSet<Integer> lottoNumberSet = new HashSet<>(winningLotto);
        if (lottoNumberSet.size() != LottoGame.getLottoNumberSize()) {
            throw new IllegalArgumentException("로또 숫자 선택 개수가 잘못되었습니다.");
        }
        if (lottoNumberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 중복 되었습니다.");
        }
    }

    public static WinningLotto valueOf(List<Integer> winningLotto, int bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
