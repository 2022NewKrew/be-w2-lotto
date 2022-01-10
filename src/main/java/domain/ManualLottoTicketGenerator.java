package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoTicketGenerator implements LottoTicketGenerator {

    @Override
    public LottoTicket generate(Set<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException();
        }
        Set<LottoNumber> numbers = lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());

        return new LottoTicket(numbers);
    }
}
