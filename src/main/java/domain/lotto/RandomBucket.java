package domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//랜덤으로 번호를 뱉어내는 담당
public class RandomBucket {
    private final List<Number> randomBucket;
    private static int START_NUMBER = 1;
    private static int END_NUMBER = 45;

    public RandomBucket() {
        randomBucket = IntStream.range(START_NUMBER, END_NUMBER + 1)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getSixRandomNumber() {
        Collections.shuffle(randomBucket);

        return IntStream.range(0, 6)
                .mapToObj(i -> randomBucket.get(i))
                .collect(Collectors.toList());
    }
}
