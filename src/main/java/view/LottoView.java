package view;

import domain.Lotto;
import domain.Person;

import java.util.List;

public class LottoView {

    private static final int MIN_COUNT_LOTTO_WINNINGS = 3;
    private static final int MAX_COUNT_LOTTO_WINNINGS = 7;

    private final Person buyer;
    List<Integer> winnings;
    List<Integer> countWinnings;

    public LottoView(Person buyer) {
        this.buyer = buyer;
    }

    public void showLotto() {
        StringBuilder result = new StringBuilder();
        List<Lotto> lottoList = buyer.getLottoList();
        result.append(lottoList.size()).append("개를 구입했습니다.\n");

        for (Lotto lotto : lottoList) {
            result.append(lotto.getLottoNumbers()).append("\n");
        }
        System.out.println(result);
    }

    public void showResult() {
        winnings = buyer.getLottoWinnings();
        countWinnings = buyer.getCorrectList();
        StringBuilder result = new StringBuilder("당첨 통계\n---------\n");

        for (int i = MIN_COUNT_LOTTO_WINNINGS; i <= MAX_COUNT_LOTTO_WINNINGS; i++) {
            result.append(makeLottoString(i));
        }
        result.append("총 수입률은 ").append(buyer.getIncomeRate()).append("% 입니다.");
        System.out.println(result);
    }

    private String makeLottoString(int rank) {
        if (rank == 6) {
            return "5개 일치, 보너스 볼 일치(" + winnings.get(rank) + "원) - " + countWinnings.get(rank) + "개\n";
        }
        if (rank == 7) {
            return rank - 1 + "개 일치 (" + winnings.get(rank) + "원) - " + countWinnings.get(rank) + "개\n";
        }
        return rank + "개 일치 (" + winnings.get(rank) + "원) - " + countWinnings.get(rank) + "개\n";
    }
}
