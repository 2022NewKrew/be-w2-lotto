package lotto.domain;

import lotto.domain.issue.IssuePolicy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public LottoMachine() {}

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
}
