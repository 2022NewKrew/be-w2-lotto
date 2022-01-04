package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamLottoView extends LottoView {

    private final Scanner sc;
    private final PrintStream out;

    public StreamLottoView(InputStream in, PrintStream out) {
        sc = new Scanner(in);
        this.out = out;
    }

    @Override
    public void showPaymentPrompt(LottoContext context) {
        out.println("구입금액을 입력해 주세요.");
        String input = sc.nextLine();
        int payment = Integer.parseInt(input);
        presenter.onPaymentInput(context, payment);
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
    public void showWinningNumbersPrompt(LottoContext context) {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        String[] split = input.split(",\\s*");
        List<Integer> winningNumbers = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(sc.nextLine());
        presenter.onWinningNumbersInput(context, winningNumbers, bonusNumber);
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
