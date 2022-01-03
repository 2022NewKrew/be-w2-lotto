package be.w2.lotto.View;

import be.w2.lotto.Domain.LottoTicket;
import be.w2.lotto.Domain.LottoTickets;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void printString(String str) {
        System.out.println(str);
    }

    public void printStatistics(List<List<Integer>> statistics) {
        printString("당첨 통계\n----------");
        for (List<Integer> statistic : statistics)
            printString(String.format("%d개 일치 (%d원) - %d개", statistic.get(0), statistic.get(1), statistic.get(2)));
    }

    public void queryBuyMoney() {
        printString("구입금액을 입력해주세요");
    }

    public void printBuyAmount(int amount) {
        printString(String.format("%d 개를 구입하셨습니다", amount));
    }

    public void queryLastNumber() {
        printString("지난 주 당첨 번호를 입력해주세요.");
    }

    public void printBenefit(int benefit) {
        printString(String.format("총 수익률은 %d %%입니다.", benefit));
    }

    public List<Integer> readIntList() {
        String intListStr = readStr();
        return strToIntList(intListStr);
    }

    public List<Integer> strToIntList(String str) {
        String[] numStrs = str.split(",");
        List<Integer> nums = new ArrayList<>();
        for (String numStr : numStrs)
            nums.add(Integer.valueOf(numStr.trim()));
        return nums;
    }

    public String readStr() {
        Input<String> target = new Input<>();
        while (!readStrInput(target))
            flush();
        return target.getValue();
    }

    private boolean readStrInput(Input target) {
        String input = null;
        try {
            input = scanner.nextLine();
            target.setValue(input);
            flush();
        } catch (InputMismatchException e) {
            System.out.println("문자열을 입력해주세요!");
            return false;
        }
        return true;
    }

    public int readInt() {
        Input<Integer> target = new Input<>();
        while (!readIntInput(target))
            flush();
        return target.getValue();
    }

    public void printTickets(LottoTickets lottoTickets) {
        StringBuilder sb = new StringBuilder();
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTicketList) {
            sb.append(lottoTicket.toString());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private boolean readIntInput(Input target) {
        int input = -1;
        try {
            input = scanner.nextInt();
            target.setValue(input);
            flush();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요!");
            return false;
        }
        return true;
    }

    private void flush() {
        scanner.nextLine();
    }


}
