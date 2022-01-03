package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.RandomLottoStrategy;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningResult;
import lotto.dto.WinningResultResponse;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {

    private WinningNumber winningNumber;

    public List<Lotto> buyLotto(int lottoPrice) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount(lottoPrice); i++) {
            lottos.add(Lotto.createLotto(new RandomLottoStrategy()));
        }
        return lottos;
    }

    private int lottoCount(int lottoPrice) {
        return lottoPrice/1000;
    }

    public WinningResultResponse winningResult(List<Lotto> lottos, int lottoPrice) {
        WinningResult winningResult = new WinningResult(winningNumber);
        return winningResult.winningResultRequest(lottos, lottoPrice);
    }

    public void inputWinningNumber(List<Integer> numbers) {
        this.winningNumber = new WinningNumber(numbers);
    }
}
