package lottoStage2.domain.lotto;

import lottoStage2.domain.vo.Discrimination;
import lottoStage2.domain.winning.WinningResult;
import lottoStage2.domain.winning.WinningType;

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

    public WinningResult getWinningResult(Lotto winningLotto, int bonusNumber) {
        WinningResult winningResult = WinningResult.create();

        for (Lotto lotto : lottos) {
            Discrimination discrimination = lotto.match(winningLotto, bonusNumber);
            WinningType type = WinningType.of(discrimination);
            winningResult.addCount(type);
        }

        return winningResult;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
