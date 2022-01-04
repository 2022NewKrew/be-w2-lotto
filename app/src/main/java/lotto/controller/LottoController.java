package lotto.controller;

import lotto.domain.LottoSystem;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.RandomLottoStrategy;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningNumber;
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

    public LottoController(Scanner sc) {
        this.sc = sc;
        this.lottoSystem = new LottoSystem(new RandomLottoStrategy());
    }

    public void lottoStart() {
        int purchasePrice = IOView.inputToInt("구입금액을 입력해 주세요.", sc);
        List<Lotto> lotteries = lottoSystem.buyLotto(purchasePrice);
        LottoView.createLottoView(lotteries).printView();

        String winningNumbers = IOView.inputToString("지난 주 당첨 번호를 입력해 주세요.", sc);
        List<String> parsed = StringParsingUtil.parse(winningNumbers, ",");
        WinningNumber winningNumber = lottoSystem.inputWinningNumber(
                parsed.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
        int bonusNumberInput = IOView.inputToInt("보너스 볼을 입력해 주세요.", sc);
        BonusNumber bonusNumber = lottoSystem.inputBonusNumber(bonusNumberInput);

        WinningResultOutput result = lottoSystem.winningResult(lotteries, winningNumber, bonusNumber, purchasePrice);
        WinningResultView.createWinningResultView(result.getWinningResult(), result.getEarningRate()).printView();
    }
}
