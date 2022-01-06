package org.cs.finn.lotto.domain;

import org.cs.finn.lotto.domain.lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
    public static final int PRICE = 1000;

    private final List<LottoNumbers> list = new ArrayList<>();

    public void add(final LottoNumbers lottoNumbers) {
        list.add(Objects.requireNonNull(lottoNumbers));
    }

    public void addAll(final List<LottoNumbers> lottoNumbersList) {
        list.addAll(Objects.requireNonNull(lottoNumbersList));
    }

    public List<LottoNumbers> getList() {
        return Collections.unmodifiableList(list);
    }

    public int size() {
        return list.size();
    }
}
