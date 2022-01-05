package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {
    private final ArrayList<Lotto> manualLottos;
    private final ArrayList<Lotto> automaticLottos;

    public LottoMachine() {
        automaticLottos = new ArrayList<>();
        manualLottos = new ArrayList<>();
    }

    public LottoMachine(List<Lotto> lottos) {
        this.automaticLottos = new ArrayList<>();
        this.manualLottos = new ArrayList<>();
        this.automaticLottos.addAll(lottos);
    }

    public void addManualLottos(List<Lotto> manualLottos) {
        this.manualLottos.addAll(manualLottos);
    }

    public void buyLotto(int money) {
        for(int i = 0; i < money / 1000; i++) {
            automaticLottos.add(new Lotto());
        }
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }

    public List<Lotto> getAutomaticLottos() {
        return automaticLottos;
    }

    public List<Integer> getLottoMatchResults(WinningLotto winLotto) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        for(Lotto lotto: automaticLottos) {
            int rank = winLotto.checkMatchResult(lotto);
            if(rank != 0) {
                result.set(rank-1, result.get(rank-1) + 1);
            }
        }
        for(Lotto lotto: manualLottos) {
            int rank = winLotto.checkMatchResult(lotto);
            if(rank != 0) {
                result.set(rank-1, result.get(rank-1) + 1);
            }
        }
        return result;
    }
}
