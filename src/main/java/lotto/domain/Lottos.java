package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoGame;
import lotto.util.ShuffleUtils;

public class Lottos {

    private final List<Lotto> lottos;
    private final int customLottoCount;
    private final int autoLottoCount;

    public Lottos(List<Lotto> lottos, int customLottoCount, int autoLottoCount) {
        validate(lottos);
        this.lottos = lottos;
        this.customLottoCount = customLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public static Lottos valueOf(int purchaseAmount, List<List<Integer>> customLottosNumbers) {
        final List<Lotto> lottos = new ArrayList<>();
        final int customLottoCount = customLottosNumbers.size();
        final int autoLottoCount = (purchaseAmount / LottoGame.getGameCost()) - customLottosNumbers.size();

        for (int i=0; i<customLottoCount; i++) {
            lottos.add(Lotto.valueOf(customLottosNumbers.get(i)));
        }
        for (int i=0; i<autoLottoCount; i++) {
            lottos.add(Lotto.valueOf(ShuffleUtils.getNumbers()));
        }
        return new Lottos(lottos, customLottoCount, autoLottoCount);
    }

    private void validate(List<Lotto> Lottos) {
        if (Lottos.isEmpty()) {
            throw new IllegalArgumentException("구매한 로또가 없습니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCustomLottoCount() {
        return customLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
