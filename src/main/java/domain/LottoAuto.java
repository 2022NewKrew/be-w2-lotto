package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAuto extends Lotto {

    private static final List<Integer> lottoNumberList;

    static {
        lottoNumberList = new ArrayList<>();

        for (int index = LOTTO_START_NUMBER; index <= LOTTO_END_NUMBER; index++) {
            lottoNumberList.add(index);
        }
    }

    public void createRandomNumber() {
        Collections.shuffle(lottoNumberList);
        numbers = new ArrayList<>(lottoNumberList.subList(0, 6));
        Collections.sort(numbers);
        Collections.unmodifiableList(numbers);
    }
}
