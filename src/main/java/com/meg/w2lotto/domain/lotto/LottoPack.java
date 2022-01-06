package com.meg.w2lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPack {

    private int size;
    private List<Lotto> lottos;

    public LottoPack(int size) {
        this.size = size;
        lottos = new ArrayList<>(size);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
