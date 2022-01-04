package lotto;

import java.util.*;

public class Game {
    private int numTickets;
    List<Ticket> ticketList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Integer> gameBoard = new HashMap<>();
    private final List<Integer> winningNumber = new ArrayList<>();
    private int bonusNumber;
    private int totalPrizeMoney = 0;
    final int bonusKey = 2;

    private void getRankResult(int rank) {
        final int prizeMoney = LotteryConstants.prizeMoney.get(rank);
        final int matches = gameBoard.getOrDefault(rank, 0);
        totalPrizeMoney = totalPrizeMoney + matches * prizeMoney;
        if (rank == bonusKey) {
            System.out.println("5개 일치, 보너스 볼 일치("+prizeMoney+"원)- " + matches + "개");
            return;
        }
        if (rank == 1) {
            System.out.println("6개 일치 ("+prizeMoney+"원)- "+matches+"개");
            return;
        }
        System.out.println(8-rank+"개 일치 ("+prizeMoney+"원)- " + matches +"개");
    }

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = LotteryConstants.numPrizes; i>0; i--) {
            getRankResult(i);
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

    private void getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = scanner.nextInt();
    }

    private void getMatches() {
        for (Ticket ticket: ticketList) {
            int matches = 0;
            List<Integer> ticketNumber = ticket.getTicketNumbers();
            for (int number : winningNumber) {
                if (ticketNumber.contains(number))
                    matches++;
            }
            if (matches == 5 && ticketNumber.contains(bonusNumber)) {
                gameBoard.put(bonusKey, gameBoard.getOrDefault(bonusKey, 0)+1);
                continue;
            }
            if (matches == 6) {
                gameBoard.put(1, gameBoard.getOrDefault(1, 0)+1);
                continue;
            }
            if (matches >= 3) {
                gameBoard.put(8-matches, gameBoard.getOrDefault(8-matches, 0)+1);
            }

        }
    }

    void run() {
        getTickets();
        getWinningNumber();
        getBonusNumber();
        getMatches();
        printResult();
    }
}
