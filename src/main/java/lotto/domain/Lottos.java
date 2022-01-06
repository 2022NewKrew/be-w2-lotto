package lotto.domain;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Lottos implements Iterable<Lotto>{
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator(){
        return lottos.iterator();
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
