package lotto.domain.issue;

import lotto.domain.Lotto;

import java.util.List;

public class ManualIssuePolicy implements IssuePolicy {

    private final List<Integer> numberList;

    public ManualIssuePolicy(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @Override
    public Lotto issue() {
        return new Lotto(numberList);
    }
}
