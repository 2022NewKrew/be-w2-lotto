package be.w2.lotto.Domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottoNumbers implements Iterable<LottoNumber>{

    private static int NUMBER_AMOUNT = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(){
        lottoNumbers = new ArrayList<>();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers){
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    public static LottoNumbers getInstanceByIntList(List<Integer> numbers){
        LottoNumbers lottoNumbers = new LottoNumbers();
        for(int number : numbers)
            lottoNumbers.add(new LottoNumber(number));
        return lottoNumbers;
    }

    public LottoNumbers getRandomTicketNumbers(){
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers.subList(0, NUMBER_AMOUNT));
    }

    public void add(LottoNumber lottoNumber){
        lottoNumbers.add(lottoNumber);
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }

    public String toString(){
        return lottoNumbers.toString();
    }

    public int size() {
        return lottoNumbers.size();
    }
}
