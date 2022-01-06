package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final int autoCount;
    private final int manualCount;

    public Lottos(int autoCount, int manualCount) {
        this.lottos = new ArrayList<>();
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    public List<LottoRanks> compareLottos(WinningNumber winningNumber) {
        List<LottoRanks> lottoRanks = new ArrayList<>();
        for (Lotto lotto: lottos){
            LottoRanks rank = lotto.compareLotto(winningNumber);
            lottoRanks.add((rank));
        }

        return lottoRanks;
    }

    public void addAll(List<Lotto> lottos){
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getTotalCount(){
        return autoCount + manualCount;
    }
}
