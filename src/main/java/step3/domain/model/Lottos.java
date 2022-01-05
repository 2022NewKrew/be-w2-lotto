package step3.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottosQuantity) {
        this.lottos = new ArrayList<>();
        makeLottos(lottosQuantity);
    }

    public Lottos(List<Lotto> manualLottos, int autoLottosQuantity) {
        this.lottos = new ArrayList<>();

        if (manualLottos.size() > 0) {
            addManualLottos(manualLottos);
        }

        makeLottos(autoLottosQuantity);
    }

    private void addManualLottos(List<Lotto> manualLottos) {
        this.lottos.addAll(manualLottos);
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
            sb.append(lotto.toString());
        }

        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}
