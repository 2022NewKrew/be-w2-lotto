package lotto.dto;

import java.util.List;
import lotto.domain.WinningLotto;

public class WinningLottoDto {

    private final List<Integer> winningLottoNumbers;

    public WinningLottoDto(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public static WinningLottoDto winningLottoToDto(WinningLotto winningLotto) {
        return new WinningLottoDto(winningLotto.getWinningLotto());
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
