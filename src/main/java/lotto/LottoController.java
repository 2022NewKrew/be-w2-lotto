package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoController {

    private LottoController() {
    }

    public static void start(InputView inputView, OutputView outputView) {
        int inputPrice = inputView.getInputPrice();
        outputView.printLottoTicketCount(inputPrice);

        Money inputMoney = new Money(inputPrice);
        LottoNumbersGenerator lottoNumbersGenerator = new RandomLottoNumberGenerator();
        LottoTickets lottoTickets = LottoMachine.issue(inputMoney, lottoNumbersGenerator);
        outputView.printLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = createWinningNumbers(inputView);

        LottoStatistics lottoStatistics = LottoStatistics.of(winningNumbers, lottoTickets, inputMoney);
        outputView.printLottoStatistics(inputMoney, lottoStatistics);
    }

    private static WinningNumbers createWinningNumbers(InputView inputView) {
        LottoNumbers lottoNumbers = createLottoNumbers(inputView.getWinningNumbers());
        LottoNumber bonusNumber = createLottoNumber(inputView.getBonusNumber());

        return WinningNumbers.from(lottoNumbers, bonusNumber);
    }

    private static LottoNumbers createLottoNumbers(String[] strings) {
        return LottoNumbers.from(
                Arrays.stream(strings)
                        .map(Integer::parseInt)
                        .map(LottoNumber::from)
                        .collect(Collectors.toSet())
        );
    }

    private static LottoNumber createLottoNumber(int number) {
        return LottoNumber.from(number);
    }
}
