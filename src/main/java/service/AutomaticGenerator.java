package service;

import domain.Lotto;
import domain.Number;

import java.util.ArrayList;
import java.util.Collections;

import static utils.Symbol.MAX_LOTTO_RANGE;

public class AutomaticGenerator implements LottoGenerator {
    ArrayList<Number> numberList;

    public AutomaticGenerator(){
        numberList = new ArrayList<>();
        for(int i = 1; i <= MAX_LOTTO_RANGE; i++){
            numberList.add(new Number(i));
        }
        generate();
    }

    public Lotto generate(){
        Collections.shuffle(numberList);
        return new Lotto(new ArrayList<Number>(numberList.subList(0,6)));
    }
}
