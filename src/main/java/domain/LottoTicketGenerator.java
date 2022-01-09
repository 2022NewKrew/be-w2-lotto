package domain;

import java.util.Set;

public interface LottoTicketGenerator {
    LottoTicket generate(Set<Integer> lottoNumbers);
}
