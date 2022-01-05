package valid;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static domain.Lotto.*;

public final class ConditionCheck {

    /**+
     * 인자 값이 양의 정수인지 판단하는 메소드입니다.
     * @param number
     * @return 양의 정수면 true, 아니면 false
     */
    public static boolean isPositiveInteger(int number) {
        return number > 0;
    }

    /**+
     * 인자 값이 음의 정수인지 판단하는 메소드입니다.
     * @param number
     * @return 음의 정수면 true, 아니면 false
     */
    public static boolean isNegativeInteger(int number) {
        return number < 0;
    }

    /**+
     * 인자 값이 로또 만들기에 적합한 수인지 판단하는 메소드입니다.
     * @param numbers
     * @return 로또 만들기에 적합하면 true, 아니면 false
     */
    public static boolean isValidLottoNumber(List<Integer> numbers) {
        return numbers.stream().allMatch(ConditionCheck::isLottoNumber) && isDistinctLottoNumbers(numbers);
    }

    /**+
     * 인자 값이 로또번호 범위 내에 있는지 판단하는 메소드입니다.
     * @param number
     * @return 로또 번호 범위 내에 있으면 true, 아니면 false
     */
    public static boolean isLottoNumber(int number) {
        return MIN_LOTTO_NUMBER.getValue() <= number && number <= MAX_LOTTO_NUMBER.getValue();
    }

    /**+
     * 인자의 개수가 중복없이 필요한 로또 번호 개수만큼 있는지 판단하는 메소드입니다.
     * @param numbers
     * @return 중복없이 필요한 로또 번호 개수만큼 있으면 true, 아니면 false
     */
    public static boolean isDistinctLottoNumbers(List<Integer> numbers) {
        Set<Integer> nums = new HashSet<>(numbers);
        return nums.size() == NUMBER_OF_LOTTO_NUMBERS.getValue();
    }
}
