package lotto.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.model.Prize;

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
        sb.append("\n당첨 통계\n");
        sb.append("---------\n");
        Arrays.stream(Prize.values()).forEach(prize -> {
            sb.append(prize.getNumberOfMatches());
            sb.append("개 일치 (");
            sb.append(prize.getWinnings());
            sb.append("원)- ");
            sb.append(lottoResult.getCount(prize));
            sb.append("개\n");
        });
        System.out.println(sb);
    }
}
