package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static domain.Constants.*;

public class LottoService {

    public LottoService() {
    }

    public static List<Lotto> buyLottos(int money, int manualLottoCount, List<List<LottoNumber>> manualNumbers) {
        validateMoney(money);

        int totalLottoCount = calcLottoCount(money);
        validateManualLottoCount(totalLottoCount, manualLottoCount);
        validateManualNumbers(manualLottoCount, manualNumbers);

        int autoLottocount = totalLottoCount - manualLottoCount;

        return Stream.concat(buyManualLottos(manualNumbers).stream(), buyAutoLottos(autoLottocount).stream())
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> buyAutoLottos(int count) {
        return Stream.generate(() -> new Lotto(new RandomLottoNumbersGenerator()))
                .limit(count)
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> buyManualLottos(List<List<LottoNumber>> manualNumbers) {
        return manualNumbers.stream()
                .map(ManualLottoNumbersGenerator::new)
                .map(Lotto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static int calcLottoCount(int money) {
        return (int) Math.floor(money / COST_PER_LOTTO);
    }

    private static void validateManualNumbers(int manualLottoCount, List<List<LottoNumber>> manualNumbers) {
        if (manualLottoCount != manualNumbers.size()) throw new IllegalArgumentException();
    }

    private static void validateMoney(int money) {
        if (money < 0) throw new IllegalArgumentException();
    }

    private static void validateManualLottoCount(int totalLottoCount, int manualLottoCount) {
        if (manualLottoCount < 0) throw new IllegalArgumentException();
        if (manualLottoCount > totalLottoCount) throw new IllegalArgumentException();
    }
}
