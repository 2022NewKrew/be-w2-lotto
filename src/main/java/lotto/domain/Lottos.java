package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoGame;
import lotto.util.ShuffleUtils;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    public static Lottos valueOf(int purchaseAmount, List<List<Integer>> customLottosNumbers) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<purchaseAmount / LottoGame.getGameCost(); i++) {
            lottos.add(Lotto.valueOf(ShuffleUtils.getNumbers()));
        }
        return new Lottos(lottos);
    }

    private void validate(List<Lotto> Lottos) {
        if (Lottos.isEmpty()) {
            throw new IllegalArgumentException("구매한 로또가 없습니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
