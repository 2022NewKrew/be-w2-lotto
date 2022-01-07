package lotto.view;

import lotto.domain.LotteryConstants;
import lotto.domain.LotteryGame;
import lotto.domain.Ticket;

import java.util.*;

public class InputUtils {
    final static Scanner scanner = new Scanner(System.in);


    private static int printRankResult(LotteryConstants.PrizeMoney prizeMoney, int numPrizes, int totalPrizeMoney) {
        totalPrizeMoney += numPrizes * prizeMoney.prize;
        String printMessage = prizeMoney.matches+"개 일치";
        if (prizeMoney.rank == LotteryConstants.bonusRank)
            printMessage += ", 보너스 볼 일치";
        printMessage += " ("+prizeMoney.prize+"원)- "+numPrizes+"개";
        System.out.println(printMessage);
        return totalPrizeMoney;
    }

    public static void printResult(Map<Integer, Integer> gameResult, int numTickets) {
        int totalPrizeMoney = 0;
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LotteryConstants.PrizeMoney p: LotteryConstants.PrizeMoney.values()) {
            int numPrizes = gameResult.getOrDefault(p.rank, 0);
            totalPrizeMoney = printRankResult(p, numPrizes, totalPrizeMoney);
        }
        System.out.println("총 수익률은 "+ getRateOfReturn(totalPrizeMoney, numTickets)  + "%입니다.");
    }

    private static long getRateOfReturn(int totalPrizeMoney, int numTickets) {
        int principal = numTickets*1000;
        return (long) ((double)(totalPrizeMoney-principal)/((double)principal))*100;
    }

    public static int getNumTickets() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine()) / 1000;
    }

    public static int getNumManualTickets(int numTickets) throws IllegalArgumentException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numManualTickets = Integer.parseInt(scanner.nextLine());
        if (numManualTickets > numTickets)
            throw new IllegalArgumentException("구매한 로또 수 이상으로 수동으로 구매할 수 없습니다.");
        if (numManualTickets < 0)
            throw new IllegalArgumentException("잘못된 입력값입니다. (음수)");
        return numManualTickets;
    }

    private static List<Integer> parseTicketNumbers(String[] inputArray) {
        List<Integer> ticketNumbers = new ArrayList<>();
        for (String s: inputArray)
            ticketNumbers.add(Integer.parseInt(s));
        return ticketNumbers;
    }


    public static List<Ticket> getManualTickets(int numTickets) {
        List<Ticket> manualTicketList = new ArrayList<>();
        if (numTickets==0)
            return manualTicketList;
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i=0; i<numTickets; i++) {
            List<Integer> manualTicketInput = parseTicketNumbers(scanner.nextLine().split(",\\s*"));
            manualTicketList.add(new Ticket(manualTicketInput));
        }
        return manualTicketList;
    }


    public static List<Integer> getWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        for (String s: scanner.nextLine().split(",\\s*")) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }

    public static int getBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }


    public static void printTickets(LotteryGame game) {
        System.out.println("수동으로 "+ game.numManualTickets +"장, 자동으로 "+(game.numTickets-game.numManualTickets) +"개를 구매했습니다.");
        for (Ticket t: game.ticketList) {
            System.out.println(t.getTicketNumbers());
        }
    }

}
