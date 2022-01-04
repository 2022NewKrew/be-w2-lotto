package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoStrategy;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningResult;
import lotto.dto.WinningResultOutput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSystem {

    private final static int LOTTO_PRICE = 1000;
    private final LottoStrategy lottoStrategy;

    public LottoSystem(LottoStrategy lottoStrategy) {
        this.lottoStrategy = lottoStrategy;
    }

    public List<Lotto> buyLotto(int lottoPrice) {
        return IntStream.range(0, lottoCount(lottoPrice))
                .mapToObj(n -> Lotto.createLotto(lottoStrategy))
                .collect(Collectors.toList());
    }

    private int lottoCount(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE;
    }

    public WinningResultOutput winningResult(List<Lotto> lotteries, WinningNumber winningNumber, BonusNumber bonusNumber, int lottoPrice) {
        WinningResult winningResult = new WinningResult(winningNumber, bonusNumber);
        return winningResult.winningResultRequest(lotteries, lottoPrice);
    }

    public WinningNumber inputWinningNumber(List<Integer> numbers) {
        return new WinningNumber(numbers);
    }

    public BonusNumber inputBonusNumber(int number) {
        return new BonusNumber(number);
    }
}
