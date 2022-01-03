package Lotto.view;

import Lotto.domain.LottoManager;
import Lotto.domain.LottoStatistics;
import Lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIprinter {


    public static void start(){
        LottoManager lottoManager = new LottoManager();
        LottoStatistics lottoStatistics = new LottoStatistics();


        lottoManager.buyTickets(getPrice());     // 구입금액 입력 and 로또 복권 구입
        printTickets(lottoManager.getTickets()); // 로또 출력

        // 지난 주 당첨 번호 입력
        lottoManager.setResults(getLastNum());
        // 로또 통계 계산
        lottoStatistics.calculateStatistics(lottoManager.getInvestmentAmount(), lottoManager.getTickets(), lottoManager.getResults());
        // 로또 통계 출력
        printStatistics(lottoStatistics.getMatched3num(), lottoStatistics.getMatched4num(),
                lottoStatistics.getMatched5num(), lottoStatistics.getMatched6num(), lottoStatistics.getRateOfProfit());
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
    public static void printStatistics(int matched3num, int matched4num, int matched5num, int matched6num, int rateOfProfit){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- "+matched3num+"개");
        System.out.println("4개 일치 (50000원)- "+matched4num+"개");
        System.out.println("5개 일치 (1500000원)- "+matched5num+"개");
        System.out.println("6개 일치 (2000000000원)- "+matched6num+"개");
        System.out.println("총 수익률은 "+rateOfProfit+"%입니다.");
    }
}
