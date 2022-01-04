package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {


    private final List<Lotto> Lottos;

    public Lottos(List<Lotto> Lottos) {
        this.Lottos = new ArrayList<>(Lottos);
    }

    public static Lottos purchaseLottos(int countOfPurchaseLotto){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfPurchaseLotto; i++) {
            lottos.add(Lotto.purchaseLotto());
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(Lottos);
    }

    public int size(){
        return this.Lottos.size();
    }
}
