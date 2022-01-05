package lotto;

import java.util.ArrayList;
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

    public RankCount getRankCount(WinningLotto winLotto) {
        RankCount rankCount = new RankCount();
        for(Lotto lotto: automaticLottos) {
            Rank rank = winLotto.getRank(lotto);
            rankCount.increaseRankCounts(rank);
        }
        for(Lotto lotto: manualLottos) {
            Rank rank = winLotto.getRank(lotto);
            rankCount.increaseRankCounts(rank);
        }
        return rankCount;
    }
}
