package lottoStage1;

import java.util.Random;

public class RandomUtils {
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 45;
    private static final Random RANDOM = new Random();

    private RandomUtils() {

    }

    public static int nextInt() {
        return RANDOM.nextInt(MAX_BOUND) + MIN_BOUND;
    }
}
