package view;

import domain.Prize;
import domain.Report;
import domain.lottery.Ticket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private final static Scanner scanner = new Scanner(System.in);

    public int getBudgetByPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showBoughtTickets(List<Ticket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        System.out.println(tickets.stream().map(ticket -> ticket.getNumbers().toString()).collect(Collectors.joining(System.lineSeparator())));
        System.out.println();
    }

    public List<Integer> getResultNumbersByPrompt() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.asList(scanner.nextLine().split(",")).stream().map(String::strip).map(Integer::valueOf).collect(Collectors.toList());
    }

    public int getResultBonusBallByPrompt() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showReport(Report report) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(Prize.FIFTH.getWinningMatchingCount() + "개 일치 (" + Prize.FIFTH.getValue() + "원)- " + report.prizeCount.get(Prize.FIFTH) + "개");
        System.out.println(Prize.FOURTH.getWinningMatchingCount() + "개 일치 (" + Prize.FOURTH.getValue() + "원)- " + report.prizeCount.get(Prize.FOURTH) + "개");
        System.out.println(Prize.THIRD.getWinningMatchingCount() + "개 일치 (" + Prize.THIRD.getValue() + "원)- " + report.prizeCount.get(Prize.THIRD) + "개");
        System.out.println(Prize.SECOND.getWinningMatchingCount() + "개 일치, 보너스 볼 일치(" + Prize.SECOND.getValue() + "원)- " + report.prizeCount.get(Prize.SECOND) + "개");
        System.out.println(Prize.FIRST.getWinningMatchingCount() + "개 일치 (" + Prize.FIRST.getValue() + "원)- " + report.prizeCount.get(Prize.FIRST) + "개");
        System.out.println("총 수익률은 " + toPercentage(report.getProfitRate(), 2) + "입니다.");
    }

    private static String toPercentage(double rate, int numOfDigits) {
        return String.format("%." + numOfDigits + "f", rate * 100) + "%";
    }
}
