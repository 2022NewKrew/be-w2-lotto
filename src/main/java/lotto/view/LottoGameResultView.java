package lotto.view;

import java.util.List;
import lotto.dto.LottoDTO;

public class LottoGameResultView {

    private static final int FIRST_PLACE_PRIZE = 2000000000;
    private static final int SECOND_PLACE_PRIZE = 1500000;
    private static final int THIRD_PLACE_PRIZE = 50000;
    private static final int FOURTH_PLACE_PRIZE = 5000;
    private static final double RATIO_BASE = 100.0;

    private static final int COUNT_FOR_FIRST_PLACE = 6;
    private static final int COUNT_FOR_SECOND_PLACE = 5;
    private static final int COUNT_FOR_THIRD_PLACE = 4;
    private static final int COUNT_FOR_FOURTH_PLACE = 3;

    private static final int COUNTED = 1;
    private static final int NOT_COUNTED = 0;

    private static final String GAME_RESULT_STRING_FORMAT = "%n당첨 통계%n"
        + "---------%n"
        + "3개 일치 (%d원) - %d개%n"
        + "4개 일치 (%d원) - %d개%n"
        + "5개 일치 (%d원) - %d개%n"
        + "6개 일치 (%d원) - %d개%n"
        + "총 수익률은 %d%%입니다.%n";

    private int firstPlaceCount;
    private int secondPlaceCount;
    private int thirdPlaceCount;
    private int fourthPlaceCount;

    public LottoGameResultView(LottoDTO winningLotto, List<LottoDTO> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> recordLottoResult(winningLotto, lottoTicket));
    }

    public void printLottoGameResult(int purchasePrice) {
        double profitRatio = calculateProfitRatio(purchasePrice);
        System.out.println(
            String.format(GAME_RESULT_STRING_FORMAT,
                FOURTH_PLACE_PRIZE, fourthPlaceCount,
                THIRD_PLACE_PRIZE, thirdPlaceCount,
                SECOND_PLACE_PRIZE, secondPlaceCount,
                FIRST_PLACE_PRIZE, firstPlaceCount,
                (int) profitRatio));
    }

    private double calculateProfitRatio(int purchasePrice) {
        return (double) totalPrize() / (double) purchasePrice * RATIO_BASE;
    }

    private int totalPrize() {
        return FIRST_PLACE_PRIZE * firstPlaceCount + SECOND_PLACE_PRIZE * secondPlaceCount
            + THIRD_PLACE_PRIZE * thirdPlaceCount + FOURTH_PLACE_PRIZE * fourthPlaceCount;
    }

    private void recordLottoResult(LottoDTO winningLotto, LottoDTO lottoTicket) {
        int containingWinningNumber = countContainingWinningNumberInTicket(winningLotto,
            lottoTicket);

        if (isConditionForFirstPlace(containingWinningNumber)) {
            firstPlaceCount++;
        } else if (isConditionForSecondPlace(containingWinningNumber)) {
            secondPlaceCount++;
        } else if (isConditionForThirdPlace(containingWinningNumber)) {
            thirdPlaceCount++;
        } else if (isConditionForFourthPlace(containingWinningNumber)) {
            fourthPlaceCount++;
        }
    }

    private int countContainingWinningNumberInTicket(LottoDTO winningLotto, LottoDTO lottoTicket) {
        return winningLotto.getLottoNumbers().stream()
            .map(winningNumber -> lottoTicket.contains(winningNumber) ? COUNTED : NOT_COUNTED)
            .reduce(0, Integer::sum);
    }

    private boolean isConditionForFirstPlace(int containingWinningNumber) {
        return containingWinningNumber == COUNT_FOR_FIRST_PLACE;
    }

    private boolean isConditionForSecondPlace(int containingWinningNumber) {
        return containingWinningNumber == COUNT_FOR_SECOND_PLACE;
    }

    private boolean isConditionForThirdPlace(int containingWinningNumber) {
        return containingWinningNumber == COUNT_FOR_THIRD_PLACE;
    }

    private boolean isConditionForFourthPlace(int containingWinningNumber) {
        return containingWinningNumber == COUNT_FOR_FOURTH_PLACE;
    }
}
