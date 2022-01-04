package view;

import domain.LottoPrize;
import domain.LottoTicket;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public final class StandardOutLottoServiceRenderer implements LottoServiceRenderer {
    @Override
    public void displaySentence(String sentence) {
        System.out.println(sentence);
    }

    @Override
    public void displayLotto(LottoTicket lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    @Override
    public void displayResults(Map<LottoPrize, Long> winningTickets, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("------------------------------");
        Arrays.stream(LottoPrize.values()).forEach( lottoPrize -> displayResult(lottoPrize, winningTickets));

        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    private void displayResult(LottoPrize lottoPrize, Map<LottoPrize, Long> winningTickets) {
        long numberOfMatches = lottoPrize.getNumberOfMatches();
        long prizeMoney = lottoPrize.getPrizeMoney();
        long count = Optional.ofNullable(winningTickets.get(lottoPrize)).orElse(0L);

        if(lottoPrize == LottoPrize.SECOND_PLACE) {
            System.out.println(numberOfMatches + "개 일치, 보너스 볼 일치(" + prizeMoney + "원)- " + count + "개");
        }
        else if(lottoPrize != LottoPrize.NOTHING) {
            System.out.println(numberOfMatches + "개 일치 (" + prizeMoney + "원)- " + count + "개");
        }
    }
}
