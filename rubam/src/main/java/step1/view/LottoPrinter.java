package step1.view;

import step1.domain.LotteryTicket;

import java.util.List;

public class LottoPrinter {

    private static final String message = "개를 구매했습니다.";

    public static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + message);
    }

    public static void printAllTickets(List<LotteryTicket> tickets) {
        for(LotteryTicket ticket : tickets) {
            printTicketNumbers(ticket);
        }
    }

    private static void printTicketNumbers(LotteryTicket ticket) {
        System.out.print("[");
        int index = 0;
        for(int number : ticket.getNumbersData()) {
            System.out.print(number + " ");
        }
        System.out.println("]");
    }

    private static void printComma() {

    }
}
