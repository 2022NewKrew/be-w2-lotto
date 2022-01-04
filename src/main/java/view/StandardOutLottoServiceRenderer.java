package view;

import domain.LottoPrize;
import domain.LottoStatus;
import domain.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class StandardOutLottoServiceRenderer implements LottoServiceRenderer {
    @Override
    public void displaySentence(String sentence) {
        System.out.println(sentence);
    }


    @Override
    public void displayPurchaseStatus(List<LottoTicket> lottoes) {
        long numberOfManualTicket = lottoes.stream().filter(e -> e.getPurchaseWay() == LottoStatus.MANUAL).count();
        long numberOfAutoTicket = lottoes.stream().filter(e -> e.getPurchaseWay() == LottoStatus.AUTO).count();

        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", numberOfManualTicket, numberOfAutoTicket);

        lottoes.forEach(this::displayLotto);
    }

    private void displayLotto(LottoTicket lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    @Override
    public void displayResults(Map<LottoPrize, Long> winningTickets, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("------------------------------");
        Arrays.stream(LottoPrize.values()).filter(e -> e != LottoPrize.NOTHING).forEach(lottoPrize -> displayResult(lottoPrize, winningTickets));

        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    private void displayResult(LottoPrize lottoPrize, Map<LottoPrize, Long> winningTickets) {
        long count = Optional.ofNullable(winningTickets.get(lottoPrize)).orElse(0L);

        System.out.print(lottoPrize.getNumberOfMatches() + "개 일치");
        if(lottoPrize.getAllowBonusBall()) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + lottoPrize.getPrizeMoney() + "원)- " + count + "개");
    }
}
