package valid;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static domain.Lotto.ZERO;
import static domain.Lotto.NUMBER_OF_LOTTO_NUMBERS;
import static domain.Lotto.MAX_LOTTO_NUMBER;

public final class ConditionCheck {

    /**+
     * 인자 값이 양의 정수인지 판단하는 메소드입니다.
     * @param number
     * @return 양의 정수면 true, 아니면 false
     */
    public static boolean isPositiveInteger(int number) {
        return number > ZERO.getValue();
    }

    /**+
     * 인자 값이 가능한 로또 번호인지 판단하는 메소드입니다.
     * @param number
     * @return 인자 값이 로또 번호로 가능하면 true, 아니면 false
     */
    public static boolean isLottoNumber(int number) {
        return ZERO.getValue() < number && number <= MAX_LOTTO_NUMBER.getValue();
    }

    /**+
     * 인자 값에 중복 값이 없는지 판단하는 메소드입니다.
     * @param numbers
     * @return 인자 값에 중복값이 없으면 true, 아니면 false
     */
    public static boolean isDistinctNumbers(List<Integer> numbers) {
        Set<Integer> nums = new HashSet<>(numbers);
        return nums.size() == NUMBER_OF_LOTTO_NUMBERS.getValue();
    }
}
