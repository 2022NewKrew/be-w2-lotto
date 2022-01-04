package lotto;

import java.util.*;

public class Game {
    private int numTickets;
    List<Ticket> ticketList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Integer> gameBoard = new HashMap<>();
    private final List<Integer> winningNumber = new ArrayList<>();

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        int totalPrizeMoney = 0;

        for (int i = LotteryConstants.minMatchForPrize; i<=LotteryConstants.ticketLength; i++) {
            int prizeMoney = LotteryConstants.prizeMoney.get(i);
            int matches = gameBoard.getOrDefault(i, 0);
            totalPrizeMoney = totalPrizeMoney + matches * prizeMoney;
            System.out.println(i+"개 일치 ("+prizeMoney+"원)- " + matches +"개");
        }
        System.out.println("총 수익률은 "+ getRateOfReturn(totalPrizeMoney)  + "%입니다.");
    }

    private long getRateOfReturn(int totalPrizeMoney) {
        return (long) ((double)totalPrizeMoney/((double)numTickets*1000))*100;
    }

    private void getTickets() {
        System.out.println("구입금액을 입력해 주세요.");
        numTickets = scanner.nextInt() / 1000;
        System.out.println(numTickets+"개를 구매했습니다.");

        for (int i=0; i< numTickets; i++) {
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
            System.out.println(ticket.getTicketNumbers());
        }
        System.out.println();
    }

    private void getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        for (String s: scanner.nextLine().split(",\\s*")) {
            winningNumber.add(Integer.parseInt(s));
        }
    }

    private void getMatches() {
        for (Ticket ticket: ticketList) {
            int matches = 0;
            List<Integer> ticketNumber = ticket.getTicketNumbers();
            for (int number : winningNumber) {
                if (ticketNumber.contains(number))
                    matches++;
            }
            if (matches >= 3)
                gameBoard.put(matches, gameBoard.getOrDefault(matches, 0)+1);
        }
    }

    void run() {
        getTickets();
        getWinningNumber();
        getMatches();
        printResult();
    }
}
