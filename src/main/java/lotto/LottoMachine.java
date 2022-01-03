package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {
    private final ArrayList<Lotto> lottos;

    public LottoMachine() {
        lottos = new ArrayList<>();
    }

    public LottoMachine(List<Lotto> lottos) {
        this.lottos = new ArrayList<>();
        this.lottos.addAll(lottos);
    }

    public void buyLotto(int money) {
        for(int i = 0; i < money / 1000; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> countLottoMatch(Lotto winLotto) {
        List<Integer> match = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0));
        for(Lotto lotto: lottos) {
            int count = winLotto.countMatch(lotto);
            match.set(count, match.get(count) + 1);
        }
        return match;
    }
}
