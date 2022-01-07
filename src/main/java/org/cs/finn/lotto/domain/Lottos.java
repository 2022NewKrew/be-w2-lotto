package org.cs.finn.lotto.domain;

import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.cs.finn.lotto.util.Checker;
import org.cs.finn.lotto.util.LottoNumbersGenerator;

import java.security.SecureRandom;
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

    public List<LottoNumbers> getList() {
        return Collections.unmodifiableList(list);
    }

    public int size() {
        return list.size();
    }

    public void buyLottoAutoAll(final SecureRandom sRand, final int count) {
        Objects.requireNonNull(sRand);
        Checker.checkInt(count, false);

        for (int i = 0; i < count; i++) {
            list.add(LottoNumbersGenerator.getLottoNumbers(sRand));
        }
    }
}
