package lotto.domain.generator;

import lotto.domain.ticket.Ticket;

public interface Generator {

    /**
     * 복권을 발급.
     * @return Lotto 인스턴스
     */
    Ticket generate();
}
