package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public List<Lotto> purchaseLottoTickets(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets).boxed().map(x -> new Lotto())
            .collect(Collectors.toList());
    }
}
