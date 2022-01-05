package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generateTickets();
}