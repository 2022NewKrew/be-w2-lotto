package view.console.dto.lottoticket;

import domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsInputDto {

    private final List<LottoTicketInputDto> lottoTicketInputDtos;

    public LottoTicketsInputDto(List<LottoTicketInputDto> lottoTicketInputDtos) {
        this.lottoTicketInputDtos = lottoTicketInputDtos;
    }

    public List<LottoTicket> toLottoTickets() {
        return lottoTicketInputDtos.stream()
                .map(LottoTicketInputDto::toLottoTicket)
                .collect(Collectors.toUnmodifiableList());
    }
}
