package dto;

import java.util.List;

public class LotteryTicketsDTO {
    public final List<LotteryTicketDTO> lotteryTicketDTOS;
    public final int size;

    public LotteryTicketsDTO(List<LotteryTicketDTO> lotteryTicketDTOS) {
        this.lotteryTicketDTOS = lotteryTicketDTOS;
        size = lotteryTicketDTOS.size();
    }
}
