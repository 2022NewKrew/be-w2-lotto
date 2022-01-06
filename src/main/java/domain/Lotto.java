package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private  final List<Integer> numbers = new ArrayList<>();
    public static final int NUM_OF_LOTTO = 6;

    public Lotto(List<Integer> numbers){
        sortAndAdd(numbers);
    }

    public Lotto(){
        sortAndAdd(makeRandomLottoNum());
    }
    void sortAndAdd(List<Integer> rawNumbers){
        Collections.sort(rawNumbers);
        numbers.addAll(rawNumbers);
    }

    private List<Integer> makeRandomLottoNum(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateRandomLotto().subList(0,NUM_OF_LOTTO);
    }

    private int countNumbersMatch(Lotto prize){
        return (int) this.numbers.stream().filter(prize::contains).count();
    }
    public Ranking makeLottoRank(Lotto prize){
        switch (countNumbersMatch(prize)){
            case 3:
                return Ranking.THREE;
            case 4:
                return Ranking.FOUR;
            case 5:
                return Ranking.FIVE;
            case 6:
                return Ranking.SIX;
            default:
                return Ranking.NONE;
        }
    }

    public boolean contains(int num){
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
