package domain.lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RandomBucketTest {

    @Test
    @DisplayName("랜덤으로 숫자 6개 뽑아내기")
    void getSixRandomNumberTest() {
        //given
        RandomBucket randomBucket = new RandomBucket();

        //when
        List<Number> sixRandomNumber = randomBucket.getSixRandomNumber();

        //then
        Assertions.assertEquals(6, sixRandomNumber.size());
        sixRandomNumber = sixRandomNumber.stream()
                .distinct()
                .collect(Collectors.toList());
        Assertions.assertEquals(6, sixRandomNumber.size());
    }
}