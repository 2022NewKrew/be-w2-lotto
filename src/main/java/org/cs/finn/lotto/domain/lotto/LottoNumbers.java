package org.cs.finn.lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoNumbers {
    public static final LottoNumbers NONE = new LottoNumbers();
    public static final int SIZE = 6;
    public static final int ADDITIVE = 1;

    private final List<LottoNumber> list;

    public LottoNumbers(List<LottoNumber> list)
            throws IllegalArgumentException
    {
        Objects.requireNonNull(list);
        if (list.size() != SIZE) {
            throw new IllegalArgumentException("list's size is not " + SIZE + "!");
        }
        validateNumbers();
        this.list = list;
    }

    public LottoNumbers(final String[] numbers)
            throws IllegalArgumentException
    {
        final List<LottoNumber> lottoNumberList = genList(Objects.requireNonNull(numbers));
        if (lottoNumberList.size() != SIZE) {
            throw new IllegalArgumentException("Valid value count is not " + SIZE + "!");
        }

        this.list = lottoNumberList;
        validateNumbers();
    }

    private void validateNumbers() {
        final Map<LottoNumber, Integer> mapCount = new HashMap<>();
        for (LottoNumber lottoNumber : list) {
            mapCount.put(lottoNumber, mapCount.getOrDefault(lottoNumber, 0) + ADDITIVE);
        }

        int maxCount = 0;
        for (LottoNumber lottoNumber : list) {
            maxCount = Math.max(maxCount, mapCount.getOrDefault(lottoNumber, 0));
        }

        if (maxCount > 1) {
            throw new IllegalArgumentException("list have duplicate LottoNumber!");
        }
    }

    private LottoNumbers() {
        final List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        this.list = list;
    }

    private List<LottoNumber> genList(final String[] values) {
        final List<LottoNumber> list = new ArrayList<>();
        for (String value : values) {
            addOnlyValidValue(list, value);
        }

        return list;
    }

    private void addOnlyValidValue(final List<LottoNumber> list, final String value) {
        if (list.size() > SIZE) {
            return;
        }

        LottoNumber lottoNumber;
        try {
            lottoNumber = new LottoNumber(value);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            return;
        }

        if (!list.contains(lottoNumber)) {
            list.add(lottoNumber);
        }
    }

    public List<LottoNumber> getList() {
        return Collections.unmodifiableList(list);
    }

    public boolean isNone() {
        return this.equals(NONE);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return list.contains(Objects.requireNonNull(lottoNumber));
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
