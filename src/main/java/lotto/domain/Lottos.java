package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos valueOf(int lottoCount) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    // 당첨개수 반환
    public Map<Integer, Integer> matchCounts(WinningLotto winningLotto) {
        return null;
    }
}
