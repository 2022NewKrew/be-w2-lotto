package view;

import domain.LottoPrize;
import domain.LottoTicket;
import domain.WinningStatus;

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
    public void displayPurchaseStatus(List<LottoTicket> lottoTickets, int numberOfManualTickets, int numberOfAutoTickets) {
        System.out.println("수동으로 " + numberOfManualTickets + "장, 자동으로 " + numberOfAutoTickets + "개를 구매했습니다.");

        lottoTickets.forEach(this::displayLotto);
    }

    private void displayLotto(LottoTicket lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    @Override
    public void displayResults(WinningStatus winningStatus, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("------------------------------");

        final Map<LottoPrize, Long> myWinningStatus = winningStatus.getWinningStatus(); //TODO: 변수명 고민

        Arrays.stream(LottoPrize.values()).filter(e -> e != LottoPrize.NOTHING).forEach(lottoPrize -> displayResult(lottoPrize, myWinningStatus));

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
