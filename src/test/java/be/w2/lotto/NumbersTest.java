package be.w2.lotto;

import be.w2.lotto.Domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumbersTest {

    @Test
    void duplicateTest(){
        assertThatThrownBy(()->{
            LottoNumbers.getInstanceByIntList(Arrays.asList(1,2,3,1,2,3));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
