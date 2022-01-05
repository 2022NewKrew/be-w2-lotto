package lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.model.LottoTickets;

public class LottoTicketsDTO {

    private final List<LottoDTO> lottoDTOs;

    public static LottoTicketsDTO from(LottoTickets lottoTickets) {
        return new LottoTicketsDTO(lottoTickets.getLottoTickets()
            .stream().map(LottoDTO::from).collect(Collectors.toList()));
    }

    private LottoTicketsDTO(List<LottoDTO> lottoDTOs) {
        this.lottoDTOs = lottoDTOs;
    }

    public int lottoTicketSize() {
        return lottoDTOs.size();
    }

    public List<LottoDTO> getLottoDTOs() {
        return Collections.unmodifiableList(lottoDTOs);
    }
}
