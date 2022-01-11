package lotto.domain;

import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Lottos implements Iterable<Lotto>{
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }
    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator(){
        return lottos.iterator();
    }

    public LottoResult match(WinningLotto winningLotto){
        LottoResult lottoResult = new LottoResult();
        for(Lotto lotto : this.lottos){
            int countOfMatch = lotto.howManyMatch(winningLotto);
            boolean matchBonus = lotto.contains(winningLotto.getBonusNumber());

            lottoResult.addResult(countOfMatch, matchBonus);
        }
        return lottoResult;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottos) {
            builder.append(lotto.toString());
            builder.append("\n");
        }
        return builder.toString();
    }


    public int size() {
        return this.lottos.size();
    }
}
