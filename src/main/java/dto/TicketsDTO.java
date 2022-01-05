package dto;

import java.util.List;

public class TicketsDTO {
    public final List<TicketDTO> ticketDTOs;
    public final int size;

    public TicketsDTO(List<TicketDTO> ticketDTOs) {
        this.ticketDTOs = ticketDTOs;
        size = ticketDTOs.size();
    }
}
