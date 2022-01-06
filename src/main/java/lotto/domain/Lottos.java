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

    public static Lottos from(int lottoCount) {
        return from(lottoCount, new ArrayList<>());
    }

    public static Lottos from(int lottoCount, List<List<Integer>> selfLottoNumbers) {
        int autoBuySize = lottoCount - selfLottoNumbers.size();
        validateSize(autoBuySize);
        final List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> selfLottoNumber : selfLottoNumbers) {
            lottos.add(new Lotto(selfLottoNumber));
        }
        for (int i = 0; i < autoBuySize; i++) {
            lottos.add(new Lotto());
        }
        return new Lottos(lottos);
    }

    private static void validateSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("[ERROR] 총 구매 장수보다 수동구입이 많을 수 없습니다.");
        }
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public LottoResult matchCounts(WinningLotto winningLotto) {
        final Map<Reward, Integer> rewardCounter = new EnumMap<>(Reward.class);
        for (Lotto lotto : lottos) {
            Reward reward = winningLotto.matchResult(lotto);
            int count = rewardCounter.getOrDefault(reward, 0);
            rewardCounter.put(reward, count + 1);
        }
        return new LottoResult(rewardCounter);
    }
}
