package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    private final List<Integer> randomNumbers;

    private RandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = new ArrayList<>(randomNumbers);
    }

    public static RandomNumbers createRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            randomNumbers.add(i);
        }
        return new RandomNumbers(randomNumbers);
    }

    public List<Integer> shuffle(){
        Collections.shuffle(this.randomNumbers);
        return this.randomNumbers;
    }
}
