package lotto.controller;

import lotto.domain.LottoSystem;
import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.number.LottoNumberFactory;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.WinningNumber;
import lotto.dto.WinningResultInput;
import lotto.dto.WinningResultOutput;
import lotto.view.IOView;
import lotto.view.LottoView;
import lotto.view.WinningResultView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class LottoController {

    private final BufferedWriter output;
    private final BufferedReader input;
    private final LottoSystem lottoSystem;
    private Lotteries lotteries;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private int purchasePrice;

    public LottoController(BufferedWriter output, BufferedReader input) {
        this.output = output;
        this.input = input;
        this.lottoSystem = new LottoSystem(new LottoNumberFactory());
    }

    public void lottoStart() throws IOException {
        buyLotto();
        inputWinningNumber();
        inputBonusNumber();
        result();
    }

    private void buyLotto() throws IOException {
        this.purchasePrice = IOView.inputToInt("구입금액을 입력해 주세요.", input, output);
        int manualCount = IOView.inputToInt("수동으로 구매할 로또 수를 입력해 주세요.", input, output);

        List<List<Integer>> manualLotteries = IOView.inputToDoubleList("수동으로 구매할 번호를 입력해 주세요.", input, output, manualCount);

        this.lotteries = lottoSystem.buyLotto(purchasePrice, manualLotteries);
        LottoView.createLottoView(lotteries.forView(), manualCount).printView(output);
    }

    private void inputWinningNumber() throws IOException {
        List<Integer> winningNumbers = IOView.inputToList("지난 주 당첨 번호를 입력해 주세요.", input, output);
        this.winningNumber = lottoSystem.inputWinningNumber(winningNumbers);
    }

    private void inputBonusNumber() throws IOException {
        int bonusNumberInput = IOView.inputToInt("보너스 볼을 입력해 주세요.", input, output);
        this.bonusNumber = lottoSystem.inputBonusNumber(bonusNumberInput, winningNumber);
    }

    private void result() throws IOException {
        WinningResultOutput result = lottoSystem.winningResult(
                lotteries,
                new WinningResultInput(winningNumber, bonusNumber),
                purchasePrice);

        WinningResultView.createWinningResultView(result.getWinningResult(), result.getEarningRate()).printView(output);
    }
}
