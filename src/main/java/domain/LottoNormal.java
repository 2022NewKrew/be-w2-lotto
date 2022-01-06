package domain;

import java.util.List;

/**
 * 수동으로 뽑은 로또 객체입니다. 생성 할시 로또 번호를 주입합니다.
 *
 * @author jm.hong
 */
public class LottoNormal extends Lotto {
    /**
     *
     * @param numbers 수동으로 뽑은 로또 번호를 주입합니다.
     * @exception 6자리가 아닌 경우, 중복된 숫자가 있는 경우
     */
    public LottoNormal(List<Integer> numbers) {
        super();
        this.numbers = numbers;
        validationOfkNumbers();
    }

}
