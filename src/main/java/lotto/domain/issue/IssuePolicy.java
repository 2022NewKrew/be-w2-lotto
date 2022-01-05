package lotto.domain.issue;

import lotto.domain.Lotto;

public interface IssuePolicy {

    /**
     * 복권을 발급.
     * @return Lotto 인스턴스
     */
    Lotto issue();

}
