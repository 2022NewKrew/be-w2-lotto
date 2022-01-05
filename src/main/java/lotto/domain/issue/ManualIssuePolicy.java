package lotto.domain.issue;

import lotto.domain.Lotto;

import java.util.List;

public class ManualIssuePolicy implements IssuePolicy {

    private final List<List<Integer>> numberListList;
    private int index = 0;

    public ManualIssuePolicy(List<List<Integer>> manualPurchaseNumberList) {
        this.numberListList = manualPurchaseNumberList;
    }

    @Override
    public Lotto issue() {
        return new Lotto(numberListList.get(index++));
    }
}
