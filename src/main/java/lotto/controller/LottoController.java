package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.issue.IssuePolicy;
import lotto.domain.issue.RandomIssuePolicy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final Lottos lottos;

    public LottoController() {
        this.lottos = new Lottos();
    }

    /**
     * 구매금액을 입력받고, 발행정책에 따라 복권을 구입하고, 복권 리스트를 출력.
     */
    public void buyLotto() {
        int purchaseAmount = InputView.getPurchaseAmount();
        IssuePolicy issuePolicy = new RandomIssuePolicy();
        lottos.addLotto(purchaseAmount, issuePolicy);
        OutputView.printLottos(lottos.size(), lottos.toString());
    }

    /**
     * 당첨번호, 보너스볼을 입력받고, 복권 리스트의 당첨 여부를 확인하고, 수익률을 계산하고, 당첨 통계를 출력.
     */
    public void checkLotto() {
        List<Integer> winningNumberList = InputView.getWinningNumberList();
        int bonusNumber = InputView.getBonusNumber();
        lottos.checkLottoList(winningNumberList, bonusNumber);
        OutputView.printLottoResults(lottos.getEarningRate());
    }
}
