package domain;

import constant.Constants;
import domain.lottonumber.LottoNumber;
import dto.LottoMatchResultDto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoTicket> lottoTickets;
    private LottoResults lottoResults;

    public Lotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getNumberOfLottoTicket() {
        return lottoTickets.size();
    }

    public LottoResults getResult() {
        return lottoResults;
    }

    public void checkLottoResult(List<LottoNumber> winningNumbers) {
        lottoResults = new LottoResults();

        for (LottoTicket lottoTicket : lottoTickets) {
            match(winningNumbers, lottoTicket);
        }
    }

    public long getEarnedMoney() {
        return Arrays.stream(LottoResult.values())
                .mapToLong(lottoResult -> lottoResults.getCountBy(lottoResult) * lottoResult.getPrizeMoney())
                .sum();
    }

    public long getPrice() {
        return lottoTickets.size() * Constants.LOTTO_PRICE;
    }

    private void match(List<LottoNumber> winningNumbers, LottoTicket lottoTicket) {
        LottoMatchResultDto lottoMatchResultDto = lottoTicket.getNumberOfMatchedNumber(winningNumbers);
        LottoResult.getLottoResultType(lottoMatchResultDto).ifPresent(lottoResults::addLottoResult);
    }

    public List<String> getLottoTicketsView() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.toList());
    }
}
