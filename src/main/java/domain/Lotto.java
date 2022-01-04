package domain;

import common.LottoStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static int LOTTO_END_NUMBER = 45;
    private static int LOTTO_START_NUMBER = 1;
    private static List<Integer> lottoNumberList;
    private LottoStatus type;

    static {
        lottoNumberList = new ArrayList<>();

        for (int index = LOTTO_START_NUMBER; index <= LOTTO_END_NUMBER; index++) {
            lottoNumberList.add(index);
        }
    }

    private List<Integer> numbers;


    public void createRandomNumber() {
        Collections.shuffle(lottoNumberList);
        this.numbers = new ArrayList<>(lottoNumberList.subList(0, 6));
        Collections.sort(this.numbers);
        this.type = LottoStatus.NORMAL;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
