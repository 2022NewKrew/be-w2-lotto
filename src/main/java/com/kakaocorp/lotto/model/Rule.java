package com.kakaocorp.lotto.model;

import java.util.Random;

public class Rule {

    private final Random random;
    private final int minNumber;
    private final int maxNumber;
    private final int numberCount;
    private final int price;

    private Rule(Random random, int minNumber, int maxNumber, int numberCount, int price) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numberCount = numberCount;
        this.random = random;
        this.price = price;
    }

    public Random getRandom() {
        return random;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int getPrice() {
        return price;
    }

    public static class Builder {

        private Random random;
        private int minNumber;
        private int maxNumber;
        private int numberCount;
        private int price;

        public Builder random(Random random) {
            this.random = random;
            return this;
        }

        public Builder minNumber(int minNumber) {
            this.minNumber = minNumber;
            return this;
        }

        public Builder maxNumber(int maxNumber) {
            this.maxNumber = maxNumber;
            return this;
        }

        public Builder numberCount(int numberCount) {
            this.numberCount = numberCount;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Rule build() {
            return new Rule(random, minNumber, maxNumber, numberCount, price);
        }
    }
}
