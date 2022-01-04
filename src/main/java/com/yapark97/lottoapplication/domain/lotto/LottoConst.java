package com.yapark97.lottoapplication.domain.lotto;

import java.util.List;

public final class LottoConst {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;

    public static final List<Integer> WINNING_CONDITION = List.of(3, 4, 5, 6);
    public static final List<Integer> WINNING_PRIZE = List.of(5000, 50000, 1500000, 2000000000);
}
