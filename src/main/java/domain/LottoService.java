package domain;

import java.util.*;
import java.util.stream.Stream;

public class LottoService {
    private static final double COST_PER_LOTTO = 1000.0;
    private static final int INITIAL_COUNT = 0;
    private static final int FOURTH_RANK = 3;
    private static final int THIRD_RANK = 4;
    private static final int SECOND_RANK = 5;
    private static final int FIRST_RANK = 6;
    private static final int MINIMUM_MATCH_COUNT = 3;

    private final List<Lotto> lottos = new ArrayList<>();
    private final Integer money;

    public LottoService(Integer money) {
        this.money = Optional.ofNullable(money).orElseThrow(IllegalArgumentException::new);
        validateMoney();

        generateLottos();
    }

    private void validateMoney() {
        if (money < 0) throw new IllegalArgumentException();
    }

    private void generateLottos() {
        Stream.generate(LottoNumberGenerator::generate)
                .limit(calcLottoCount())
                .map(Lotto::new)
                .forEach(lottos::add);
    }

    private int calcLottoCount() {
        return (int) Math.floor(money / COST_PER_LOTTO);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<Integer, Integer> getWinningResult(List<Integer> winningNumbers) {
        Map<Integer, Integer> winningResult = new HashMap<>() {{
            put(FOURTH_RANK, INITIAL_COUNT);
            put(THIRD_RANK, INITIAL_COUNT);
            put(SECOND_RANK, INITIAL_COUNT);
            put(FIRST_RANK, INITIAL_COUNT);
        }};

        lottos.stream()
                .map(lotto -> lotto.getWinningCount(winningNumbers))
                .filter(count -> count >= MINIMUM_MATCH_COUNT)
                .forEach(count -> winningResult.put(count, winningResult.get(count) + 1));

        return Collections.unmodifiableMap(winningResult);
    }
}
