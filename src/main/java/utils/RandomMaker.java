package utils;

import java.util.Random;

public class RandomMaker {

    private final Random random;

    public RandomMaker() {
        this.random = new Random();
    }

    public RandomMaker(Random random) {
        this.random = random;
    }

    public Integer getRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
