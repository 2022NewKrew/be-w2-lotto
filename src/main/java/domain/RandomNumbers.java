package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    private final List<Integer> randomNumbers;

    private RandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = new ArrayList<>(randomNumbers);
    }

    public static RandomNumbers createRandomNumbers(){
        List<Integer> randomNumbers = IntStream.range(1,45)
            .boxed()
            .collect(Collectors.toList());

        return new RandomNumbers(randomNumbers);
    }

    public List<Integer> shuffle(){
        Collections.shuffle(this.randomNumbers);
        return this.randomNumbers;
    }
}
