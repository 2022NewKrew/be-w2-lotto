package step2.domain;

import java.util.List;

public class LottoConfig {

    private Integer purchaseAmount;
    private IssueConditionType issueCondition = IssueConditionType.AUTO;
    private List<List<Integer>> userInputLottoList;

    public LottoConfig(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public IssueConditionType getIssueCondition() {
        return issueCondition;
    }

    public List<List<Integer>> getUserInputLottoList() {
        return userInputLottoList;
    }
}
