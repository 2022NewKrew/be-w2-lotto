package service;

import domain.Lotto;
import domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.Symbol.LOTTO_SIZE;
import static utils.Symbol.MAX_LOTTO_RANGE;

public class AutomaticGenerator implements LottoGenerator {
    List<Number> numberList;

    public AutomaticGenerator() {
        numberList = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_RANGE; i++) {
            numberList.add(new Number(i));
        }
        generate();
    }

    @Override
    public Lotto generate() {
        Collections.shuffle(numberList);
        List<Number> subNumberList = new ArrayList<>(numberList.subList(0, LOTTO_SIZE));
        Collections.sort(subNumberList);
        return new Lotto(subNumberList);
    }
}
