package lotto.domain;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.number.Lotto;
import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.strategy.LottoStrategy;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.WinningNumber;
import lotto.domain.result.WinningResult;
import lotto.dto.WinningResultOutput;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoSystem {

    private final LottoStrategy lottoStrategy;

    public LottoSystem(LottoStrategy lottoStrategy) {
        this.lottoStrategy = lottoStrategy;
    }

    public Lotteries buyLotto(int lottoPrice, List<List<Integer>> manualLotteries) {
        List<Lotto> lotteries = addAutoLotto(new Money(lottoPrice), manualLotteries.size());
        addManualLotto(lotteries, manualLotteries);

        return Lotteries.create(lotteries);
    }

    private List<Lotto> addAutoLotto(Money lottoPrice, int manualLotteriesLength) {
        return IntStream.range(0, lottoPrice.howManyAutoLottoBuy(manualLotteriesLength))
                .mapToObj(n -> Lotto.createLotto(lottoStrategy))
                .collect(toList());
    }

    private void addManualLotto(List<Lotto> lotteries, List<List<Integer>> manualLotteries) {
        lotteries.addAll(manualLotteries.stream()
                .map(Lotto::createManualLotto)
                .collect(toList()));
    }

    public WinningResultOutput winningResult(Lotteries lotteries, WinningNumber winningNumber, BonusNumber bonusNumber, int lottoPrice) {
        WinningResult winningResult = new WinningResult(winningNumber, bonusNumber);
        return winningResult.winningResultRequest(lotteries, lottoPrice);
    }

    public WinningNumber inputWinningNumber(List<Integer> numbers) {
        return new WinningNumber(numbers);
    }

    public BonusNumber inputBonusNumber(int number, WinningNumber winningNumber) {
        validBonusNumber(number, winningNumber);
        return new BonusNumber(number);
    }

    private void validBonusNumber(int number, WinningNumber winningNumber) {
        if (winningNumber.isContainWinningNumber(new Number(number))) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 겹쳐서는 안됩니다");
        }
    }
}
