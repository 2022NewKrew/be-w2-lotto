package lotto.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;

import java.util.List;

public class LottoConsoleView implements LottoView {

    public LottoConsoleView() {
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
        sb.append(lottoResult.toString());
        System.out.println(sb);
    }

    public void printEarningsRate(double percent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("총 수익률은 %d%%입니다.\n", percent));
        System.out.println(sb);
    }
}
