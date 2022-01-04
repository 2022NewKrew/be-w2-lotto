package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.issue.IssuePolicy;
import lotto.domain.issue.RandomIssuePolicy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoMachine lottoMachine;
    private List<Lotto> lottoList;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    /**
     * 구매금액을 입력받고, 발행정책에 따라 복권을 구입하고, 복권 리스트를 출력.
     */
    public void buyLotto() {
        int purchaseAmount = InputView.getPurchaseAmount();
        IssuePolicy issuePolicy = new RandomIssuePolicy();
        lottoList = lottoMachine.purchaseLotto(purchaseAmount, issuePolicy);
        OutputView.printLottos(lottoList);
    }

    public void checkLotto() {
    }
}
