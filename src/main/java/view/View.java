package view;

import domain.LotteryPrize;
import dto.LotteryReportDTO;
import dto.LotteryTicketsDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public int getBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getNumberOfNonRandomTickets() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void promptToInputLotteryNumbersToBuy() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public void showBoughtTickets(LotteryTicketsDTO nonRandomLotteryTicketsDTO, LotteryTicketsDTO randomLotteryTicketsDTO) {
        System.out.println("수동으로 " + nonRandomLotteryTicketsDTO.size + "장, 자동으로 " + randomLotteryTicketsDTO.size + "개를 구매했습니다.");
        System.out.println(nonRandomLotteryTicketsDTO.lotteryTicketDTOS.stream().map(ticketDTO -> ticketDTO.numbers.toString()).collect(Collectors.joining(System.lineSeparator())));
        System.out.println(randomLotteryTicketsDTO.lotteryTicketDTOS.stream().map(ticketDTO -> ticketDTO.numbers.toString()).collect(Collectors.joining(System.lineSeparator())));
        System.out.println();
    }

    public List<Integer> getResultNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLotteryNumbers();
    }

    public List<Integer> getLotteryNumbers() {
        return Arrays.stream(scanner.nextLine().split(",")).map(String::strip).map(Integer::valueOf).collect(Collectors.toList());
    }

    public int getResultBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showReport(LotteryReportDTO lotteryReportDTO) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(LotteryPrize.FIFTH.getWinningMatchingCount() + "개 일치 (" + LotteryPrize.FIFTH.getValue() + "원)- " + lotteryReportDTO.prizeCount.get(LotteryPrize.FIFTH) + "개");
        System.out.println(LotteryPrize.FOURTH.getWinningMatchingCount() + "개 일치 (" + LotteryPrize.FOURTH.getValue() + "원)- " + lotteryReportDTO.prizeCount.get(LotteryPrize.FOURTH) + "개");
        System.out.println(LotteryPrize.THIRD.getWinningMatchingCount() + "개 일치 (" + LotteryPrize.THIRD.getValue() + "원)- " + lotteryReportDTO.prizeCount.get(LotteryPrize.THIRD) + "개");
        System.out.println(LotteryPrize.SECOND.getWinningMatchingCount() + "개 일치, 보너스 볼 일치(" + LotteryPrize.SECOND.getValue() + "원)- " + lotteryReportDTO.prizeCount.get(LotteryPrize.SECOND) + "개");
        System.out.println(LotteryPrize.FIRST.getWinningMatchingCount() + "개 일치 (" + LotteryPrize.FIRST.getValue() + "원)- " + lotteryReportDTO.prizeCount.get(LotteryPrize.FIRST) + "개");
        System.out.println("총 수익률은 " + toPercentage(lotteryReportDTO.profitRate, 2) + "입니다.");
    }

    private static String toPercentage(double rate, int numOfDigits) {
        return String.format("%." + numOfDigits + "f", rate * 100) + "%";
    }
}
