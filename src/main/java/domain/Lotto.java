package domain;

import constant.Constants;
import domain.lottonumber.LottoNumber;

import java.util.*;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Lotto {

    private final List<LottoTicket> lottoTickets;

    public Lotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getNumberOfLottoTicket() {
        return lottoTickets.size();
    }

    public LottoResults checkLottoResults(List<LottoNumber> winningNumbers) {
        return new LottoResults(matchTickets(winningNumbers));
    }

    private Map<LottoResult, Long> matchTickets(List<LottoNumber> winningNumbers) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.match(winningNumbers))
                .flatMap(Optional::stream)
                .collect(groupingBy(identity(), counting()));
    }

    public long getPrice() {
        return lottoTickets.size() * Constants.LOTTO_PRICE;
    }

    public List<String> getLottoTicketsView() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(toList());
    }
}
