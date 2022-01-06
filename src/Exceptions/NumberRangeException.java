package Exceptions;

import Controller.LotteryController;
import Domain.Tickets.Ticket;

public class NumberRangeException extends Exception {
    private String msg = String.format("번호를 범위에 맞춰 다시 입력해 주세요. 번호의 범위는 %d부터 %d까지 입니다.", Ticket.getMinNumber(), Ticket.getMaxNumber());
    public NumberRangeException() {
        LotteryController.print(msg);
    }
}
