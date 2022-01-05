package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final ArrayList<UserLotto> manualLottos;
    private final ArrayList<UserLotto> automaticLottos;

    public LottoMachine() {
        automaticLottos = new ArrayList<>();
        manualLottos = new ArrayList<>();
    }

    public LottoMachine(List<UserLotto> lottos) {
        this.automaticLottos = new ArrayList<>();
        this.manualLottos = new ArrayList<>();
        this.automaticLottos.addAll(lottos);
    }

    public void addManualLottos(List<UserLotto> manualLottos) {
        this.manualLottos.addAll(manualLottos);
    }

    public void buyLotto(int money) {
        for(int i = 0; i < money / 1000; i++) {
            automaticLottos.add(new UserLotto());
        }
    }

    public List<UserLotto> getManualLottos() {
        return manualLottos;
    }

    public List<UserLotto> getAutomaticLottos() {
        return automaticLottos;
    }

    public RankCount getRankCount(WinningLotto winLotto) {
        RankCount rankCount = new RankCount();
        for(UserLotto lotto: automaticLottos) {
            Rank rank = winLotto.getRank(lotto);
            rankCount.increaseRankCounts(rank);
        }
        for(UserLotto lotto: manualLottos) {
            Rank rank = winLotto.getRank(lotto);
            rankCount.increaseRankCounts(rank);
        }
        return rankCount;
    }
}
