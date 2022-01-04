package com.kakao.lottogame.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    NONE(0, Money.of(0)),
    FOURTH(3, Money.of(5_000)),
    THIRD(4, Money.of(50_000)),
    SECOND(5, Money.of(1_500_000)),
    FIRST(6, Money.of(2_000_000_000));

    private static final Map<Integer, Rank> map = Collections.unmodifiableMap(Stream.of(values())
        .collect(Collectors.toMap(Rank::getMatch, Function.identity())));

    private final int match;
    private final Money reward;

    Rank(int match, Money reward) {
        this.match = match;
        this.reward = reward;
    }

    public static Rank of(int match) {
        return Optional.ofNullable(map.get(match)).orElse(Rank.NONE);
    }

    public int getMatch() {
        return match;
    }

    public int getRewardValue() {
        return reward.getValue();
    }
}
