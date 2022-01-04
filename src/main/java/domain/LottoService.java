package domain;

import java.util.*;
import java.util.stream.Stream;

public class LottoService {
    private static final double COST_PER_LOTTO = 1000.0;

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoService() {}

    private void validateMoney(int money) {
        if (money < 0) throw new IllegalArgumentException();
    }

    public List<Lotto> buyLottos(int money) {
        validateMoney(money);

        Stream.generate(LottoNumberGenerator::generate)
                .limit(calcLottoCount(money))
                .map(Lotto::new)
                .forEach(lottos::add);

        return Collections.unmodifiableList(lottos);
    }

    private int calcLottoCount(int money) {
        return (int) Math.floor(money / COST_PER_LOTTO);
    }
}
