package org.cs.finn.lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final LottoNumbers NONE = new LottoNumbers();
    public static final int SIZE = 6;

    private final List<LottoNumber> list;

    public LottoNumbers(List<LottoNumber> list)
            throws IllegalArgumentException
    {
        this.list = Objects.requireNonNull(list);
        if (list.size() != SIZE) {
            throw new IllegalArgumentException("list's size is not " + SIZE + "!");
        }
        validateNumbers();
    }

    private void validateNumbers() {
        boolean illegal = false;
        for (LottoNumber lottoNumber : list) {
            illegal |= contains(lottoNumber);
        }

        if (illegal) {
            throw new IllegalArgumentException("list have duplicate LottoNumber!");
        }
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
