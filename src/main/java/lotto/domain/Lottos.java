package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    private static int manualPurchase;
    private static int autoPurchase;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos of(int lottoCount, List<List<Integer>> manualLottoNumbers) {
        validate(lottoCount, manualLottoNumbers);

        manualPurchase = manualLottoNumbers.size();
        autoPurchase = lottoCount - manualPurchase;

        final List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> manualLottoNumber: manualLottoNumbers) {
            lottos.add(new Lotto(manualLottoNumber));
        }
        for (int i = 0; i < lottoCount - manualLottoNumbers.size(); i++) {
            lottos.add(new Lotto());
        }
        return new Lottos(lottos);
    }

    private static void validate(int lottoCount, List<List<Integer>> manualLottoNumbers) {
        if (lottoCount <= manualLottoNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 수동으로 입력한 로또가 구매 가능한 횟수를 초과했습니다.");
        }
    }

    public static Lottos of(int lottoCount) {
        return of(lottoCount, new ArrayList<>());
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getManualPurchase() {
        return manualPurchase;
    }

    public int getAutoPurchase() {
        return autoPurchase;
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
