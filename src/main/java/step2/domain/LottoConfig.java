package step2.domain;

import java.util.List;

public class LottoConfig {

    // 구매 금액
    private Integer purchaseAmount;
    // 자동 or 수동 여부
    private IssueConditionType issueCondition = IssueConditionType.AUTO;
    // 수동일 경우, 유저가 입력한 로또 번호(6개)의 리스트
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
