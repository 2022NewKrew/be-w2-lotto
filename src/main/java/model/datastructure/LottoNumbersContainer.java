package model.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LottoNumbersContainer implements Iterable<LottoNumber>{
    private final ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumber get(int i) {
        return lottoNumbers.get(i);
    }

    public int add(LottoNumber lottoNumber) {
        lottoNumbers.add(lottoNumber);
        return lottoNumbers.lastIndexOf(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public void forEach(Consumer<? super LottoNumber> action) {
        lottoNumbers.forEach(action);
    }

    @Override
    public Spliterator<LottoNumber> spliterator() {
        return lottoNumbers.spliterator();
    }

    public int size() {
        return lottoNumbers.size();
    }
}
