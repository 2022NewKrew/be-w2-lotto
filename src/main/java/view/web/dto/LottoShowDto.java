package view.web.dto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoShowDto {

    private final List<LottoTicketShowDto> lottos;
    private final int lottosSize;

    public LottoShowDto(List<String> lottoTickets) {
        lottos = lottoTickets.stream()
                .map(LottoTicketShowDto::new)
                .collect(Collectors.toUnmodifiableList());
        lottosSize = lottoTickets.size();
    }

    public List<LottoTicketShowDto> getLottos() {
        return lottos;
    }

    public int getLottosSize() {
        return lottosSize;
    }
}
