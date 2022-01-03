package view;

import domain.Report;
import domain.lottery.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    final static Scanner scanner = new Scanner(System.in);

    public int getBudgetByPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void showBoughtTickets(List<Ticket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (var ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public List<Integer> getResultNumbersByPrompt() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        for (var numberString : scanner.nextLine().split(",")) {
            numbers.add(Integer.parseInt(numberString.strip()));
        }
        return numbers;
    }

    public void showReport(Report report) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + report.getFourthPrizeValue() + "원)- " + report.getFourthPrizeCount() + "개");
        System.out.println("3개 일치 (" + report.getThirdPrizeValue() + "원)- " + report.getThirdPrizeCount() + "개");
        System.out.println("3개 일치 (" + report.getSecondPrizeValue() + "원)- " + report.getSecondPrizeCount() + "개");
        System.out.println("3개 일치 (" + report.getFirstPrizeValue() + "원)- " + report.getFirstPrizeCount() + "개");
        System.out.println("총 수익률은 " + report.getProfitRateAsPercentage() + "%입니다.");
    }
}
