package lotto.domain;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.number.LottoNumberFactory;
import lotto.domain.lotto.number.Lotto;
import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.WinningNumber;
import lotto.domain.lotto.result.WinningResult;
import lotto.dto.WinningResultInput;
import lotto.dto.WinningResultOutput;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoSystem {

    private final LottoNumberFactory factory;

    public LottoSystem(LottoNumberFactory factory) {
        this.factory = factory;
    }

    public Lotteries buyLotto(int lottoPrice, List<List<Integer>> manualLotteries) {
        List<Lotto> lotteries = addAutoLotto(new Money(lottoPrice), manualLotteries.size());
        addManualLotto(lotteries, manualLotteries);

        return Lotteries.create(lotteries);
    }

    private List<Lotto> addAutoLotto(Money lottoPrice, int manualLotteriesLength) {
        return IntStream.range(0, lottoPrice.howManyAutoLottoBuy(manualLotteriesLength))
                .mapToObj(n -> Lotto.createLotto(factory.generateRandomLotto()))
                .collect(toList());
    }

    private void addManualLotto(List<Lotto> lotteries, List<List<Integer>> manualLotteries) {
        lotteries.addAll(manualLotteries.stream()
                .map(lotto -> Lotto.createLotto(factory.generateManualLotto(lotto)))
                .collect(toList()));
    }

    public WinningResultOutput winningResult(Lotteries lotteries, WinningResultInput resultInput, int lottoPrice) {
        WinningResult winningResult = new WinningResult(resultInput.getWinningNumber(), resultInput.getBonusNumber());
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
        if (winningNumber.isContainNumbers(new Number(number))) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 겹쳐서는 안됩니다");
        }
    }
}
