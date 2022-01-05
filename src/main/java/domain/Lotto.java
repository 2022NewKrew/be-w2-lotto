package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

    private  final List<Integer> numbers = new ArrayList<>();
    public static final int NUM_OF_LOTTO = 6;

    public Lotto(List<Integer> numbers){
        this.numbers.addAll(numbers);
    }

    public Lotto(){
        this.numbers.addAll(makeRandomLottoNum());
    }

    private List<Integer> makeRandomLottoNum(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateRandomLotto().subList(0,NUM_OF_LOTTO);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
