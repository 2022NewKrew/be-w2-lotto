package view;

import domain.LottoPrize;
import domain.LottoTicket;
import domain.WinningStatus;

import java.util.*;

public class SparkLottoRenderer implements LottoServiceRenderer{


    private List<String> message = new ArrayList<>();
    private double totalRateOfReturn;

    @Override
    public void displaySentence(String sentence) {
    }

    @Override
    public void displayPurchaseStatus(List<LottoTicket> lottoTickets, int numberOfManualLottoTickets, int numberOfAutoLottoTickets) {
    }

    @Override
    public void displayResults(WinningStatus winningTickets, double rateOfReturn) {
        final Map<LottoPrize, Long> myWinningStatus = winningTickets.getWinningStatus();

        Arrays.stream(LottoPrize.values()).filter(e -> e != LottoPrize.NOTHING).forEach(lottoPrize -> displayResult(lottoPrize, myWinningStatus));


        this.totalRateOfReturn = rateOfReturn;
    }

    private void displayResult(LottoPrize lottoPrize, Map<LottoPrize, Long> winningTickets) {
        long count = Optional.ofNullable(winningTickets.get(lottoPrize)).orElse(0L);
        StringBuilder sb = new StringBuilder();

        sb.append(lottoPrize.getNumberOfMatches()).append("개 일치");
        if (lottoPrize.getAllowBonusBall()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(lottoPrize.getPrizeMoney()).append("원)- ").append(count).append("개");

        message.add(sb.toString());
    }

    public List<String> getMessage() {
        return message;
    }

    public double getTotalRateOfReturn() {
        return totalRateOfReturn;
    }

    public void init() {
        message = new ArrayList<>();
        totalRateOfReturn = 0;
    }
}
