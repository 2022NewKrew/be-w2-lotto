package Lotto.view;

import Lotto.domain.Rank;
import Lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputManager {
    // 로또 복권 하나를 출력하는 메소드
    public void printTicket(Ticket ticket){
        List<String> ticketStr = new ArrayList<>();
        System.out.print("[");
        for(Integer integer : ticket.getTicket())
            ticketStr.add(String.valueOf(integer));
        System.out.print(String.join(", ", ticketStr));
        System.out.println("]");
    }

    // 전체 로또 복권을 출력하는 메소드
    public void printTickets(List<Ticket> manualTickets, List<Ticket> randomTickets){
        System.out.println("수동으로 "+manualTickets.size()+"장, 자동으로 "+randomTickets.size()+"장을 구매했습니다.");
        for(Ticket ticket : manualTickets)
            printTicket(ticket);
        for(Ticket ticket : randomTickets)
            printTicket(ticket);
    }

    // 로또 통계를 화면에 출력하는 메소드
    public void printStatistics(Map<Rank, Integer> countOfWining, long rateOfProfit){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- "+countOfWining.get(Rank.FIFTH)+"개");
        System.out.println("4개 일치 (50000원)- "+countOfWining.get(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1500000원)- "+countOfWining.get(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- "+countOfWining.get(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2000000000원)- "+countOfWining.get(Rank.FIRST)+"개");
        System.out.println("총 수익률은 "+rateOfProfit+"%입니다.");
    }
}
