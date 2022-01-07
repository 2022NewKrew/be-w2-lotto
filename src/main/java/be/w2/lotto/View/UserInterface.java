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

    public void printStatistics(List<List<String>> statistics) {
        printString("당첨 통계\n----------");
        for (List<String> statistic : statistics)
            printString(String.format("%s - %s개", statistic.get(0), statistic.get(1)));
    }

    public void queryBuyMoney() {
        printString("구입금액을 입력해주세요");
    }

    public void printBuyAmount(LottoTickets lottoTickets) {
        printString(String.format("수동으로 %d 장, 자동으로 %d 장울 구입하셨습니다", lottoTickets.getManualAmount(), lottoTickets.getAutoAmount()));
    }

    public void queryAnswerNumber() {
        printString("지난 주 당첨 번호를 입력해주세요.");
    }

    public void queryBonusNumber() {
        printString("보너스 볼을 입력해 주세요.");
    }

    public void printBenefit(long benefit) {
        printString(String.format("총 수익률은 %d %%입니다.", benefit));
    }

    public void queryManualAmount() {
        printString("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void queryManualNumbers() {
        printString("수동으로 구매할 번호를 입력해 주세요.");
    }

    public List<List<Integer>> readManualInputs(int manualAmount) {
        List<List<Integer>> manualInputList = new ArrayList<>();
        for (int i = 0; i < manualAmount; i++) {
            manualInputList.add(readIntList());
        }
        return manualInputList;
    }

    public List<Integer> readIntList() {
        String intListString = readString();
        return stringToIntList(intListString);
    }

    public List<Integer> stringToIntList(String string) {
        String[] numberStrings = string.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings)
            numbers.add(Integer.valueOf(numberString.trim()));
        return numbers;
    }

    public String readString() {
        Input<String> target = new Input<>();
        while (!readStringInput(target)) ;
        return target.getValue();
    }

    private boolean readStringInput(Input target) {
        String input = null;
        try {
            input = scanner.nextLine();
            target.setValue(input);
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


    public WebLottoResult makeWebLottosResult(List<List<String>> statistics, long earningRate){
        return new WebLottoResult(statistics, earningRate);
    }
}
