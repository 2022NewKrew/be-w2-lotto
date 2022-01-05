package lotto.domain;

import lotto.domain.issue.IssuePolicy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final String NEWLINE = System.lineSeparator();
    private static final LottoMachine lottoMachine = new LottoMachine();
    private final List<Lotto> lottoList = new ArrayList<>();
    private int purchaseAmount;
    private int prizeAmount;

    public void addLotto(int purchaseAmount, IssuePolicy issuePolicy) {
        this.lottoList.addAll(lottoMachine.purchaseLotto(purchaseAmount, issuePolicy));
        this.purchaseAmount += purchaseAmount;
    }

    public String printLottos() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoList) {
            sb.append(lotto.printNumberList());
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public int size() {
        return lottoList.size();
    }

    public int getEarningRate() {
        return (int) Math.round(prizeAmount / (double) purchaseAmount * 100);
    }

    public void checkLottoList(List<Integer> winningNumberList, int bonusNumber) {
        for (Lotto lotto : lottoList) {
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
            int matchingNumber = lotto.checkLotto(winningNumberList);
            Rank rank = Rank.valueOf(matchingNumber, hasBonusNumber);
            addPrizeAmount(rank);
        }
    }

    private void addPrizeAmount(Rank rank) {
        rank.addWinnerCount();
        prizeAmount += rank.getPrizeAmount();
    }
}
