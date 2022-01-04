package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
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

    public Map<Reward, Integer> matchCounts(WinningLotto winningLotto) {
        final Map<Reward, Integer> rewardCounter = new EnumMap<>(Reward.class);
        for (Lotto lotto: lottos) {
            Reward reward = winningLotto.matchResult(lotto);
            int count = rewardCounter.getOrDefault(reward, 0);
            rewardCounter.put(reward, count + 1);
        }
        return rewardCounter;
    }
}
