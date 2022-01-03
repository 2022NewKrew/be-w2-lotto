package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static int LOTTO_END_NUMBER = 45;
    private static int LOTTO_START_NUMBER = 1;
    private static List<Integer> lottoNumberList;

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
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
