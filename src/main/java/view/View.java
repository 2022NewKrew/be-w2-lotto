package view;

import domain.Prize;
import domain.Report;
import domain.lottery.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {
    private final static Scanner scanner = new Scanner(System.in);

    public int getBudgetByPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showBoughtTickets(List<Ticket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
        System.out.println();
    }

    public List<Integer> getResultNumbersByPrompt() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        Arrays.asList(scanner.nextLine().split(",")).forEach(numberString -> numbers.add(Integer.parseInt(numberString.strip())));
        System.out.println();
        return numbers;
    }

    public void showReport(Report report) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + Prize.FOURTH.getValue() + "원)- " + report.prizeCount.get(Prize.FOURTH) + "개");
        System.out.println("4개 일치 (" + Prize.THIRD.getValue() + "원)- " + report.prizeCount.get(Prize.THIRD) + "개");
        System.out.println("5개 일치 (" + Prize.SECOND.getValue() + "원)- " + report.prizeCount.get(Prize.SECOND) + "개");
        System.out.println("6개 일치 (" + Prize.FIRST.getValue() + "원)- " + report.prizeCount.get(Prize.FIRST) + "개");
        System.out.println("총 수익률은 " + toPercentage(report.getProfitRate(),2) + "입니다.");
    }

    private static String toPercentage(double rate, int numOfDigits){
        return String.format("%." + numOfDigits + "f", rate * 100) + "%";
    }
}
