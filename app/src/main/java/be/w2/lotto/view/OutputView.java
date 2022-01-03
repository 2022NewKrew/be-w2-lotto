package be.w2.lotto.view;

import java.util.List;

public class OutputView {
    public static void outputLottoAmounts(int lottoTicketAmount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTicketAmount);
    }

    public static void outputLottoTickets(List<List<Integer>> lottoTickets) {
        lottoTickets.forEach(System.out::println);
    }
}
