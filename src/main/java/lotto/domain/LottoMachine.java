package lotto.domain;

import lotto.domain.issue.IssuePolicy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private int purchaseAmount;
    private int prizeAmount;
    private List<Integer> winningNumberList;
    private int bonusNumber;
    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoMachine() {}

    public void start() {
        this.winningNumberList = InputView.getWinningNumberList();
        this.bonusNumber = InputView.getBonusNumber();
        checkLottoList();
        double earningRate = prizeAmount / (double) purchaseAmount * 100;
        OutputView.printLottoResults(earningRate);
    }

    /**
     * 구매금액과 발행정책을 입력받아 복권의 리스트를 반환.
     * @param purchaseAmount 구매금액
     * @param issuePolicy 발행정책
     * @return lottoList 복권의 리스트
     */
    public List<Lotto> purchaseLotto(int purchaseAmount, IssuePolicy issuePolicy) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(issuePolicy.issue());
        }
        return lottoList;
    }

    private void checkLottoList() {
        for (Lotto lotto : lottoList) {
            boolean hasBonusNumber= lotto.hasBonusNumber(bonusNumber);
            int matchingNumber = lotto.checkLotto(winningNumberList);
            Rank rank = Rank.valueOf(matchingNumber, hasBonusNumber);
            addPrizeAmount(rank);
        }
    }

    private void addPrizeAmount(Rank rank) {
        if (rank != null) {
            rank.addWinnerCount();
            prizeAmount += rank.getPrizeAmount();
        }
    }
}
