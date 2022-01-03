package com.kakao.lottogame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class Lotto {

    public static final int SIZE = 6;
    public static final Money PRICE = Money.of(1_000);

    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Lotto of(List<Number> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Number> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 총 6개입니다.");
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public int compare(Lotto lotto) {
        Set<Number> intersectSet = new HashSet<>(numbers);
        intersectSet.retainAll(lotto.numbers);
        return intersectSet.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return getNumbers().equals(lotto.getNumbers());
    }

    @Override
    public int hashCode() {
        return getNumbers().hashCode();
    }

    @Override
    public String toString() {
        final String SEPARATOR = ", ";
        return "[" + StringUtils.join(this.numbers, SEPARATOR) + "]";
    }
}
