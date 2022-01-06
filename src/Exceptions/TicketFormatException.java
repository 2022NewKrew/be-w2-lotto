package Exceptions;

import Controller.LotteryController;
import Domain.Tickets.Ticket;

public class TicketFormatException extends Exception {
    private String msg = String.format("번호를 형식에 맞춰 다시 입력해 주세요. 번호는 쉼표(,)로 구분되며, %d개의 정수를 입력해야 합니다.", Ticket.getLength());
    public TicketFormatException() {
        LotteryController.print(msg);
    }
}
