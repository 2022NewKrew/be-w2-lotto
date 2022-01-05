package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {


    private final List<Lotto> lottos;

    private Lottos(List<Lotto> Lottos) {
        this.lottos = new ArrayList<>(Lottos);
    }

    public static Lottos purchaseLottos(int countOfPurchaseLotto) {
        List<Lotto> lottos = IntStream.range(0, countOfPurchaseLotto)
            .mapToObj(i -> Lotto.purchaseLotto())
            .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public Map<Rank, Integer> winningConfirm(WinningNumbers winningNumbers) {
        Map<Rank, Integer> winningStatistics = new HashMap<>();
        for (Lotto lotto : this.lottos) {
            Rank rank = winningNumbers.countMatchNumber(lotto);
            int countOfLottoByMatch = winningStatistics.getOrDefault(rank, 0);
            winningStatistics.put(rank, countOfLottoByMatch + 1);
        }

        return winningStatistics;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return this.lottos.size();
    }
}
