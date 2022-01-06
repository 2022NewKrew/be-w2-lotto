package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 자동으로 뽑은 로또 객체입니다. 생성즉시 자동으로 생성한 번호로 초기화합니다.
 *
 * @author jm.hong
 */
public class LottoAuto extends Lotto {

    private static final List<Integer> lottoNumberList;

    static {
        lottoNumberList = new ArrayList<>();

        for (int index = LOTTO_START_NUMBER; index <= LOTTO_END_NUMBER; index++) {
            lottoNumberList.add(index);
        }
    }

    public LottoAuto() {
        createRandomNumber();
    }

    private void createRandomNumber() {
        Collections.shuffle(lottoNumberList);
        numbers = new ArrayList<>(lottoNumberList.subList(0, 6));
        Collections.sort(numbers);
        Collections.unmodifiableList(numbers);
    }
}
