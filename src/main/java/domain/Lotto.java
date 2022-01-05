package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    private  final List<Integer> numbers = new ArrayList<>();
    public static final int LOTTO_MOD = 46;
    public static final int NUM_OF_LOTTO = 6;

    public Lotto(List<Integer> numbers){
        numbers.addAll(numbers);
    }

    public Lotto(){
        for (int i = 0; i < NUM_OF_LOTTO; i++) {
            numbers.add(makeRandomLottoNum());
        }
    }

    private int makeRandomLottoNum(){
        return new Random().nextInt()%LOTTO_MOD;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
