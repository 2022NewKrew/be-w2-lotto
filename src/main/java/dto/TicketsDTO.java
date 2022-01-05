package dto;

import java.util.List;

public class TicketsDTO {
    public final List<TicketDTO> ticketDTOs;
    
    public TicketsDTO(List<TicketDTO> ticketDTOs) {
        this.ticketDTOs = ticketDTOs;
    }
}
