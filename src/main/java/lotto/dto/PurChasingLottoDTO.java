package lotto.dto;

import lotto.domain.component.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PurChasingLottoDTO {
    private final List<LottoTicket> lottoTickets;
    private final int purchasePrice;
    private final int numberOfManualLotto;
    private final int numberOfAutoLotto;

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getNumberOfManualLotto() {
        return numberOfManualLotto;
    }

    public int getNumberOfAutoLotto() {
        return numberOfAutoLotto;
    }

    public PurChasingLottoDTO(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets, int purchasePrice) {
        lottoTickets = mergeLottoTicket(manualLottoTickets, autoLottoTickets);
        numberOfManualLotto = manualLottoTickets.size();
        numberOfAutoLotto = autoLottoTickets.size();
        this.purchasePrice = purchasePrice;
    }


    private List<LottoTicket> mergeLottoTicket(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        return Stream.of(manualLottoTickets, autoLottoTickets)
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());
    }
}
