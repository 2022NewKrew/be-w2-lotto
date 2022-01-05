package lotto.controller;

import lotto.domain.LottoSystem;
import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.strategy.RandomLottoStrategy;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.WinningNumber;
import lotto.dto.WinningResultOutput;
import lotto.util.StringParsingUtil;
import lotto.view.IOView;
import lotto.view.LottoView;
import lotto.view.WinningResultView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    private final Scanner sc;
    private final LottoSystem lottoSystem;
    private Lotteries lotteries;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private int purchasePrice;

    public LottoController(Scanner sc) {
        this.sc = sc;
        this.lottoSystem = new LottoSystem(new RandomLottoStrategy());
    }

    public void lottoStart() {
        buyLotto();
        inputWinningNumber();
        inputBonusNumber();
        result();
    }

    private void buyLotto() {
        this.purchasePrice = IOView.inputToInt("구입금액을 입력해 주세요.", sc);
        int manualCount = IOView.inputToInt("수동으로 구매할 로또 수를 입력해 주세요.", sc);

        List<List<Integer>> manualLotteries = IOView.inputToDoubleList("수동으로 구매할 번호를 입력해 주세요.", sc, manualCount);

        this.lotteries = lottoSystem.buyLotto(purchasePrice, manualLotteries);
        LottoView.createLottoView(lotteries.forView(), manualCount).printView();
    }

    private void inputWinningNumber() {
        List<Integer> winningNumbers = IOView.inputToList("지난 주 당첨 번호를 입력해 주세요.", sc);
        this.winningNumber = lottoSystem.inputWinningNumber(winningNumbers);
    }

    private void inputBonusNumber() {
        int bonusNumberInput = IOView.inputToInt("보너스 볼을 입력해 주세요.", sc);
        this.bonusNumber = lottoSystem.inputBonusNumber(bonusNumberInput, winningNumber);
    }

    private void result() {
        WinningResultOutput result = lottoSystem.winningResult(lotteries, winningNumber, bonusNumber, purchasePrice);
        WinningResultView.createWinningResultView(result.getWinningResult(), result.getEarningRate()).printView();
    }
}
