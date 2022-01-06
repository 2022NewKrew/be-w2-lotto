package lotto.dto;

import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.TicketBundle;

import java.util.List;

public class LottoPurchaseResponseDto {

    /**
     * lottoBundle 은 DB가 생기고, 클라이언트가 다른 요청을 할 때 조회를 할 수 있는 정보를 넘겨줄 수 있다면 Dto 에 담지 않아도 된다고 생각합니다.
     * 여기서는 이 정보를 main 메소드에 넘겨주지 않으면 당첨 여부를 체크하기 매우 번거로워지므로 일단 넘겨주는 것으로 결정했습니다.
     * 이 변수를 삭제하게 되면 LottoBundle 의 getLottoList 메소드도 삭제해도 됩니다.
     */
    private final List<Ticket> ticketBundle;
    private final String lottoBundleString;

    public LottoPurchaseResponseDto(TicketBundle ticketBundle) {
        this.ticketBundle = List.copyOf(ticketBundle.getLottoBundle());
        this.lottoBundleString = ticketBundle.toString();
    }

    public String getLottoBundleString() {
        return lottoBundleString;
    }

    public List<Ticket> getLottoBundle() {
        return ticketBundle;
    }
}
