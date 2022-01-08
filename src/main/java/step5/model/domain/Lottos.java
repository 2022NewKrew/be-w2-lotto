package step5.model.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottosQuantity) {
        makeLottos(lottosQuantity);
    }

    public Lottos(List<Lotto> manualLottos, int autoLottosQuantity) {
        addLottos(manualLottos);
        makeLottos(autoLottosQuantity);
    }

    public Lottos() {}

    private void addLottos(List<Lotto> lottosForAdd) {
        this.lottos.addAll(lottosForAdd);
    }

    public void addLottos(Lottos newLottos) {
        for (Lotto lotto : newLottos) {
            this.lottos.add(lotto);
        }
    }

    public void addLotto(Lotto lottoForAdd) {
        this.lottos.add(lottoForAdd);
    }

    private void makeLottos(int lottosQuantity) {
        for (int i = 0; i < lottosQuantity; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public Lotto lottoOf(int i) {
        return this.lottos.get(i);
    }

    public int size() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : this.lottos) {
            sb.append(lotto.toString()).append("\n");
        }

        sb.setLength(sb.length() >= 1 ? sb.length() - 1 : 0);

        return sb.toString();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
