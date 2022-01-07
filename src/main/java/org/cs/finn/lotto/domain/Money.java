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
    private final int used;

    public Money(final String money)
            throws IllegalArgumentException
    {
        Checker.checkString(money);

        int temp = Integer.parseInt(money.trim(), 10);
        Checker.checkInt(temp, false);
        this.money = temp;
        this.used = 0;
    }

    public Money(final int money)
            throws IllegalArgumentException
    {
        Checker.checkInt(money, false);
        this.money = money;
        this.used = 0;
    }

    public Money(final int money, final int used)
            throws IllegalStateException
    {
        Checker.checkIntMinMax(used, money);
        this.money = money;
        this.used = used;
    }

    public boolean notEnoughToBuyOneLotto() {
        return (money - used) < Lottos.PRICE;
    }

    public int maxNumberToBuyLottos() {
        return (money - used) / Lottos.PRICE;
    }

    public boolean notEnoughToBuyLottos(final int count) {
        Checker.checkInt(count, false);
        return maxNumberToBuyLottos() < count;
    }

    public Money buyLottoManual(final int count)
            throws IllegalArgumentException
    {
        Checker.checkInt(count, false);
        if (notEnoughToBuyLottos(count)) {
            throw new IllegalArgumentException("Not enough money to buy " + count + " lottos!");
        }
        return new Money(money, count * Lottos.PRICE);
    }

    public Money buyLottoAutoAll() {
        return new Money(money, used + maxNumberToBuyLottos() * Lottos.PRICE);
    }

    @Override
    public String toString() {
        return NumberFormatter.strNumberWithComma(money - used) + "원";
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
