package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoService {
    private static final double COST_PER_LOTTO = 1000.0;
    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 46;

    public LottoService() {
    }

    public static List<Lotto> buyLottos(int money, int manualLottoCount, List<List<Integer>> manualNumbers) {
        validateMoney(money);

        int totalLottoCount = calcLottoCount(money);
        validateManualLottoCount(totalLottoCount, manualLottoCount);
        validateManualNumbers(manualLottoCount, manualNumbers);

        int autoLottocount = totalLottoCount - manualLottoCount;

        return Stream.concat(buyManualLottos(manualNumbers).stream(), buyAutoLottos(autoLottocount).stream())
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> buyAutoLottos(int autoCount) {
        return Stream.generate(LottoService::generateRandomLottoNumbers)
                .limit(autoCount)
                .map(Lotto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> buyManualLottos(List<List<Integer>> manualNumbers) {
        return manualNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static int calcLottoCount(int money) {
        return (int) Math.floor(money / COST_PER_LOTTO);
    }

    private static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumberList = IntStream.range(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumberList);

        return lottoNumberList.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(Collectors.toUnmodifiableList());
    }


    private static void validateManualNumbers(int manualLottoCount, List<List<Integer>> manualNumbers){
        if(manualLottoCount != manualNumbers.size()) throw new IllegalArgumentException();
    }

    private static void validateMoney(int money) {
        if (money < 0) throw new IllegalArgumentException();
    }

    private static void validateManualLottoCount(int totalLottoCount, int manualLottoCount) {
        if (manualLottoCount < 0) throw new IllegalArgumentException();
        if (manualLottoCount > totalLottoCount) throw new IllegalArgumentException();
    }
}
