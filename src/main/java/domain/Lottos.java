package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final String COUNT_OF_MANUAL_MIN_ERROR_MESSAGE = "수동으로 구매할 로또 수는 음수일 수 없습니다.";
    private static final String COUNT_OF_MANUAL_MAX_ERROR_MESSAGE = "수동으로 구매할 로또 수는 주어진 돈으로 구매가능한 로또의 수보다 클 수 없습니다.";
    private static final int COUNT_LOTTO_MIN = 0;
    private static final int LOTTO_COUNT_PLUS = 1;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> Lottos) {
        this.lottos = new ArrayList<>(Lottos);
    }

    public static Lottos purchaseLottos(int countOfPurchaseLotto, List<List<Integer>> manualLottos) {
        validateCountOfManual(manualLottos);
        int countOfAuto = countOfPurchaseLotto - manualLottos.size();
        validatecountOfAuto(countOfAuto);

        List<Lotto> lottos = manualLottos.stream()
            .map(Lotto::purchaseManualLotto)
            .collect(Collectors.toList());

        lottos.addAll(IntStream.range(COUNT_LOTTO_MIN, countOfAuto)
            .mapToObj(i -> Lotto.purchaseAutoLotto())
            .collect(Collectors.toList()));

        return new Lottos(lottos);
    }

    private static void validateCountOfManual(List<List<Integer>> manualLottos) {
        if(manualLottos==null){
            throw new IllegalArgumentException(COUNT_OF_MANUAL_MIN_ERROR_MESSAGE);
        }
    }

    private static void validatecountOfAuto(int CountOfAuto) {
        if (CountOfAuto < COUNT_LOTTO_MIN) {
            throw new IllegalArgumentException(COUNT_OF_MANUAL_MAX_ERROR_MESSAGE);
        }
    }

    public Map<Rank, Integer> winningConfirm(WinningNumbers winningNumbers) {
        Map<Rank, Integer> winningStatistics = new HashMap<>();
        for (Lotto lotto : this.lottos) {
            Rank rank = winningNumbers.countMatchNumber(lotto);
            int countOfLottoByMatch = winningStatistics.getOrDefault(rank, COUNT_LOTTO_MIN);
            winningStatistics.put(rank, countOfLottoByMatch + LOTTO_COUNT_PLUS);
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
