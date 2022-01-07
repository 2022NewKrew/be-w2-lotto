package com.meg.w2lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPack {

    private List<Lotto> lottos;
    private int capacity;

    public LottoPack(int size) {
        lottos = new ArrayList<>(size);
        capacity = size;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return lottos.size();
    }

    public int getPrice() {
        return getCount()* LottoConstant.LOTTO_COST;
    }

    public int getCapacity() {
        return capacity;
    }
}
