package org.cs.finn.lotto.domain;

import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.cs.finn.lotto.util.Checker;
import org.cs.finn.lotto.util.LottoNumbersGenerator;
import org.cs.finn.lotto.util.NumberFormatter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Money {
    public static final Money DEFAULT = new Money(5_000);

    private final int money;

    public Money(final String money)
            throws IllegalArgumentException, IllegalStateException, IndexOutOfBoundsException
    {
        Checker.checkString(money);

        int temp = Integer.parseInt(money.trim(), 10);
        Checker.checkInt(temp, false);
        this.money = temp;
    }

    public Money(final int money) {
        Checker.checkInt(money, false);
        this.money = money;
    }

    public boolean notEnoughToBuyOneLotto() {
        return money < Lottos.PRICE;
    }

    // 추후 작성 예정
//    public LottoNumbers buyLottoManual(final String[] numbers)
//            throws IllegalArgumentException
//    {
//        if (money < Lottos.PRICE) {
//            return LottoNumbers.NONE;
//        }
//
//        return new LottoNumbers(numbers);
//    }

    public List<LottoNumbers> buyLottoAutoAll(final SecureRandom sRand) {
        final List<LottoNumbers> list = new ArrayList<>();
        Objects.requireNonNull(sRand);
        for (int i = (money / Lottos.PRICE); i > 0; i--) {
            list.add(
                    LottoNumbersGenerator.getLottoNumbers(sRand)
            );
        }
        return Collections.unmodifiableList(list);
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return NumberFormatter.strNumberWithSeparator(money) + "원";
    }

    // Auto-generated code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return money == that.money;
    }

    // Auto-generated code
    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
