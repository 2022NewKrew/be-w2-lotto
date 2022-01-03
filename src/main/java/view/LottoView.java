package view;

import domain.Lotto;
import domain.Person;

import java.util.List;

public class LottoView {

    private static final int MIN_COUNT_LOTTO_WINNINGS = 3;
    private static final int MAX_COUNT_LOTTO_WINNINGS = 6;

    private Person buyer;

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
        StringBuilder result = new StringBuilder("당첨 통계\n---------\n");
        List<Integer> winnings = buyer.getLottoWinnings();
        List<Integer> countWinnings = buyer.getCorrectList();

        for (int i = MIN_COUNT_LOTTO_WINNINGS; i <= MAX_COUNT_LOTTO_WINNINGS; i++) {
            result.append(i).append("개 일치 (").append(winnings.get(i)).append("원) - ").append(countWinnings.get(i)).append("개\n");
        }
        result.append("총 수입률은 ").append(buyer.getIncomeRate()).append("% 입니다.");
        System.out.println(result);
    }
}
