package utility;

import java.util.Random;

public class RandomSeed {
    public static Random random = new Random();

    public static void setSeed(int seedNumber) {
        random = new Random(seedNumber);
    }

    public static Random getRandom() {
        return random;
    }
}
