package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RewardTypeTest {

    @ParameterizedTest
    @DisplayName("매칭 갯수와 보너스 여부에 따른 리워드 타입 반환 성공 확인")
    @MethodSource("inputAndExpected")
    void successWhenGetRewardType(int matched, boolean hasBonus, RewardType expectedType){
        assertThat(RewardType.getRewardType(matched, hasBonus)).isEqualTo(expectedType);
    }

    private static Stream<Arguments> inputAndExpected(){
        return Stream.of(
                Arguments.of(6, true, RewardType.FIRST_PLACE),
                Arguments.of(6, false, RewardType.FIRST_PLACE),
                Arguments.of(5, true, RewardType.SECOND_PLACE),
                Arguments.of(5, false, RewardType.THIRD_PLACE),
                Arguments.of(4, true, RewardType.FOURTH_PLACE),
                Arguments.of(4, false, RewardType.FOURTH_PLACE),
                Arguments.of(3, true, RewardType.NONE),
                Arguments.of(3, false, RewardType.NONE),
                Arguments.of(2, false, RewardType.NONE),
                Arguments.of(1, false, RewardType.NONE),
                Arguments.of(0, false, RewardType.NONE)
        );
    }
}