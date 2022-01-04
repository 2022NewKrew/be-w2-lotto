package view;

import domain.LottoTicket;

import java.util.Map;
import java.util.Optional;

import static domain.Lotto.*;

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
    public void displayResults(Map<Long, Long> winningTickets, int purchaseAmount) {
        long MAX = (long) NUMBER_OF_LOTTO_NUMBERS.getValue();

        System.out.println("당첨 통계");
        System.out.println("------------------------------");

        long profit = getProfit(MAX-3, FOURTH_PLACE.getValue(), Optional.ofNullable(winningTickets.get(MAX-3)).orElse(0L));
        profit += getProfit(MAX-2, THIRD_PLACE.getValue(), Optional.ofNullable(winningTickets.get(MAX-2)).orElse(0L));
        profit += getProfit(MAX-1, SECOND_PLACE.getValue(), Optional.ofNullable(winningTickets.get(MAX-1)).orElse(0L));
        profit += getProfit(MAX, FIRST_PLACE.getValue(), Optional.ofNullable(winningTickets.get(MAX)).orElse(0L));

        System.out.println("총 수익률은 " + profit * 100 / purchaseAmount + "%입니다.");
    }

    private long getProfit(long count, long value, long numOfSame) {
        System.out.println(count + "개 일치 (" + value + "원)- " + numOfSame + "개");
        return value * numOfSame;
    }
}
