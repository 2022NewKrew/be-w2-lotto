package model;

import dto.request.LottoCheckDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lotto extends BaseEntity {
    protected final List<LottoTicket> lottoTickets;
    protected final Map<LottoResult, Integer> lottoResultMap = new HashMap<>();
    protected Integer earnedPrize = 0;
    protected Boolean isChecked = false;

    protected Lotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;

        LottoResult.getEnumSet()
                .forEach(lottoResult -> {
                    this.lottoResultMap.put(lottoResult, 0);
                });
    }

    public void check(LottoCheckDTO lottoCheckDTO) {
        if (isChecked)
            return;

        lottoTickets
                .forEach(lottoTicket -> {
                    lottoTicket.calcResult(lottoCheckDTO.getWinningNumbers(), lottoCheckDTO.getBonusNumber());
                    if (lottoTicket.getResult() != LottoResult.MATCH_NONE)
                        lottoResultMap.put(lottoTicket.getResult(), lottoResultMap.get(lottoTicket.getResult()) + 1);
                    earnedPrize += lottoTicket.getResult().getPrize();
                });

        isChecked = true;
    }

    public String convertLottoToString() {
        return lottoTickets.stream()
                .map(LottoTicket::convertTicketToString)
                .collect(Collectors.joining("\n"));
    }

    public String convertResultToString() {
        StringBuilder stringBuilder = new StringBuilder();

        LottoResult.getEnumSet()
                .forEach(lottoResult -> {
                    stringBuilder.append(lottoResult.getMsg());
                    stringBuilder.append(" (");
                    stringBuilder.append(lottoResult.getPrize());
                    stringBuilder.append((")- "));
                    stringBuilder.append(lottoResultMap.get(lottoResult));
                    stringBuilder.append(("개"));
                    stringBuilder.append(("\n"));
                });

        stringBuilder.append("\n총 수익률은 ");
        stringBuilder.append(String.format("%.2f", calcRevenueRate()));
        stringBuilder.append("%입니다.");

        return stringBuilder.toString();
    }

    protected double calcRevenueRate() {
        int PRICE_OF_TICKET = 1000;
        int numberOfLotto = lottoTickets.size();
        int budget = numberOfLotto * PRICE_OF_TICKET;

        return ((float) (earnedPrize - budget) / budget) * 100.0;
    }
}
