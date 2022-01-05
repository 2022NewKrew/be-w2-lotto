package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {


    private final List<Lotto> Lottos;

    private Lottos(List<Lotto> Lottos) {
        this.Lottos = new ArrayList<>(Lottos);
    }

    public static Lottos purchaseLottos(int countOfPurchaseLotto) {
        List<Lotto> lottos = IntStream.range(0, countOfPurchaseLotto)
            .mapToObj(i -> Lotto.purchaseLotto())
            .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(Lottos);
    }

    public int size() {
        return this.Lottos.size();
    }
}
