package lotto.view;

import lotto.domain.lotto.Lotto;

import java.util.List;

public final class LottoView {

    private final List<Lotto> lottos;

    private LottoView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoView createLottoView(List<Lotto> lottos) {
        return new LottoView(lottos);
    }

    public void printView() {
        System.out.println(lottos.size() + "개를 구매했습니다");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
