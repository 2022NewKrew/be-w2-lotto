package lotto.controller;

import lotto.domain.LottoSystem;
import lotto.domain.lotto.Lotto;
import lotto.dto.WinningResultResponse;
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
        this.lottoSystem = new LottoSystem();
    }

    public void lottoStart() {
        int purchasePrice = IOView.inputToInt("구입금액을 입력해 주세요.", sc);
        List<Lotto> lottos = lottoSystem.buyLotto(purchasePrice);
        LottoView.createLottoView(lottos).printView();

        String winningNumbers = IOView.inputToString("지난 주 당첨 번호를 입력해 주세요.(,사용)", sc);
        List<String> parsed = StringParsingUtil.parse(winningNumbers, ",");
        lottoSystem.inputWinningNumber(parsed.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );

        WinningResultResponse result = lottoSystem.winningResult(lottos, purchasePrice);
        WinningResultView.createWinningResultView(result).printView();
    }
}
