package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamLottoView implements LottoView {

    private final Scanner sc;
    private final PrintStream out;

    public StreamLottoView(InputStream in, PrintStream out) {
        sc = new Scanner(in);
        this.out = out;
    }

    @Override
    public int showPaymentPrompt() {
        out.println("구입금액을 입력해 주세요.");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public int showManualCountPrompt() {
        out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public void showManualTicketPromptHeader() {
        out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    @Override
    public List<Integer> acceptManualTicketInput() {
        String input = sc.nextLine();
        String[] split = input.split(",\\s*");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public void printTicketHeader(int count) {
        //noinspection RedundantStringFormatCall
        out.println(String.format("%d개를 구매했습니다.", count));
    }

    @Override
    public void printTicket(LottoTicket ticket) {
        out.println(ticket.toArrayString());
    }

    @Override
    public List<Integer> showWinningNumbersPrompt() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        String[] split = input.split(",\\s*");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public int showBonusNumberPrompt() {
        out.println("보너스 볼을 입력해 주세요.");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public void printResultHeader() {
        out.println("당첨 통계");
        out.println("---------");
    }

    @Override
    public void printResult(LottoResult result, int count) {
        out.println(result.toPrintString(count));
    }

    @Override
    public void printProfit(int profit) {
        //noinspection RedundantStringFormatCall
        out.println(String.format("총 수익률은 %d%%입니다.", profit));
    }
}
