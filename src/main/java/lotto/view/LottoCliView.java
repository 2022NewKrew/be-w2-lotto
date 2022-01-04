package lotto.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.constant.Prize;

import java.util.Arrays;
import java.util.List;

public class LottoCliView {
    private static final LottoCliView INSTANCE = new LottoCliView();

    private LottoCliView() {
    }

    public static LottoCliView getInstance() {
        return INSTANCE;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public void printLottoResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n---------\n");
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.FAILED)
                .forEach(prize -> {
                    sb.append(String.format(
                            "%d개 일치%s(%d원) - %d개",
                            prize.getRank().getNumberOfMatches(),
                            prize.getRank().getBonus() ? ", 보너스 볼 일치" : "",
                            prize.getWinnings(),
                            lottoResult.getCount(prize)
                    ));
                    System.out.println(sb);
                    sb.setLength(0);
                });
    }

    public void printEarningsRate(double rate) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("총 수익률은 %d%%입니다.\n", Math.round(rate * 100)));
        System.out.println(sb);
    }
}
