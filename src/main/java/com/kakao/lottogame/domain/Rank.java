package com.kakao.lottogame.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    NONE(Criteria.of(0, false), Money.of(0)),
    FIFTH(Criteria.of(3, false), Money.of(5_000)),
    FOURTH(Criteria.of(4, false), Money.of(50_000)),
    THIRD(Criteria.of(5, false), Money.of(1_500_000)),
    SECOND(Criteria.of(5, true), Money.of(30_000_000)),
    FIRST(Criteria.of(6, false), Money.of(2_000_000_000));

    private static final Map<Criteria, Rank> map = Collections.unmodifiableMap(Stream.of(values())
        .collect(Collectors.toMap(Rank::getCriteria, Function.identity())));

    private final Criteria criteria;
    private final Money reward;

    Rank(Criteria criteria, Money reward) {
        this.criteria = criteria;
        this.reward = reward;
    }

    public static Rank of(Criteria criteria) {
        return Optional.ofNullable(map.get(criteria)).orElse(Rank.NONE);
    }

    private Criteria getCriteria() {
        return criteria;
    }

    public int getMatch() {
        return criteria.match;
    }

    public boolean getBonus() {
        return criteria.bonus;
    }

    public int getRewardValue() {
        return reward.getValue();
    }

    public static class Criteria {

        private final int match;
        private final boolean bonus;

        private Criteria(int match, boolean bonus) {
            this.match = match;
            this.bonus = bonus;
        }

        public static Criteria of(int match, boolean bonus) {
            return new Criteria(match, bonus);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Criteria criteria = (Criteria) o;

            if (match != criteria.match) {
                return false;
            }
            return bonus == criteria.bonus;
        }

        @Override
        public int hashCode() {
            int result = match;
            result = 31 * result + (bonus ? 1 : 0);
            return result;
        }
    }
}
