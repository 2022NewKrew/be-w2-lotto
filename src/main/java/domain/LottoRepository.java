package domain;

import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottos;

    public LottoRepository(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
