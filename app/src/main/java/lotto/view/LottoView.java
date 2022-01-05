package lotto.view;

import lotto.domain.lotto.number.Lotto;

import java.util.List;

public final class LottoView {

    private final List<Lotto> lottos;
    private final int manualCount;

    private LottoView(List<Lotto> lottos, int manualCount) {
        this.lottos = lottos;
        this.manualCount = manualCount;
    }

    public static LottoView createLottoView(List<Lotto> lottos, int manualCount) {
        return new LottoView(lottos, manualCount);
    }

    public void printView() {
        System.out.println("수동으로 " + manualCount + "장 " + "자동으로 " + (lottos.size() - manualCount) + "장을 구매했습니다");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
