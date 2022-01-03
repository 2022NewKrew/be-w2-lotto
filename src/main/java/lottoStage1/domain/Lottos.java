package lottoStage1.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int lottoCount) {
        while(lottos.size() < lottoCount) {
            lottos.add(Lotto.generate());
        }
    }

    public static Lottos purchase(int price) {
        return new Lottos(price / LOTTO_PRICE);
    }

    public WinningResult getWinningResult(Lotto winningLotto) {
        WinningResult winningResult = WinningResult.create();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winningLotto);
            WinningType type = WinningType.of(matchCount);
            winningResult.addCount(type);
        }

        return winningResult;
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
