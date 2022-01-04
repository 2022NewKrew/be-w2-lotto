package Lotto.view;

import Lotto.domain.LottoManager;
import Lotto.domain.LottoStatistics;
import Lotto.domain.Rank;
import Lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UIprinter {
    public static void start(){
        LottoManager lottoManager = new LottoManager();

        lottoManager.buyTickets(getPrice());     // 구입금액 입력 and 로또 복권 구입
        printTickets(lottoManager.getTickets()); // 로또 출력

        // 지난 주 당첨 번호 입력
        lottoManager.setResults(getLastNum());
        // 보너스 숫자 입력
        lottoManager.setBonusNumber(getBonusNumber());
        // 로또 통계 생성
        LottoStatistics lottoStatistics = new LottoStatistics(lottoManager.getInvestmentAmount(), lottoManager.getTickets(),
                lottoManager.getResults(), lottoManager.getBonusNumber());
        // 로또 통계 출력
        printStatistics(lottoStatistics.getCountOfWining(), lottoStatistics.getRateOfProfit());
    }

    // 구입 금액을 입력받는 메소드
    public static int getPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    // 로또 복권 하나를 출력하는 메소드
    public static void printTicket(Ticket ticket){
        List<String> ticketStr = new ArrayList<>();
        System.out.print("[");
        for(Integer integer : ticket.getTicket())
            ticketStr.add(String.valueOf(integer));
        System.out.print(String.join(", ", ticketStr));
        System.out.println("]");
    }

    // 전체 로또 복권을 출력하는 메소드
    public static void printTickets(List<Ticket> ticketList){
        System.out.println(ticketList.size()+"개를 구매했습니다.");
        for(Ticket ticket : ticketList)
            printTicket(ticket);
    }

    public static List<Integer> stringSplit(String string){
        List<Integer> elements = new ArrayList<>();
        for(String element: string.split(","))
            elements.add(Integer.parseInt(element));
        return elements;
    }

    // 지난 주 당첨 번호를 입력받는 메소드
    public static List<Integer> getLastNum(){
        Scanner sc = new Scanner(System.in);
        String numbers;
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (쉼표(,)로 구분해주세요)");
        numbers = sc.next();

        return stringSplit(numbers);
    }

    // 로또 통계를 화면에 출력하는 메소드
    public static void printStatistics(Map<Rank, Integer> countOfWining, long rateOfProfit){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- "+countOfWining.get(Rank.FIFTH)+"개");
        System.out.println("4개 일치 (50000원)- "+countOfWining.get(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1500000원)- "+countOfWining.get(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- "+countOfWining.get(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2000000000원)- "+countOfWining.get(Rank.FIRST)+"개");
        System.out.println("총 수익률은 "+rateOfProfit+"%입니다.");
    }

    // 보너스 숫자를 입력받는 메소드
    public static int getBonusNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
