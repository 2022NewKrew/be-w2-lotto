package step1.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottosQuantity) {
        this.lottos = new ArrayList<>();
        makeLottos(lottosQuantity);
    }

    private void makeLottos(int lottosQuantity) {
        for (int i = 0; i < lottosQuantity; i++) {
            lottos.add(new Lotto());
        }
    }

    public Lotto lottoOf(int i) {
        return lottos.get(i);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
        }

        return sb.toString();
    }
}
