package lotto.collections;

import lotto.utils.Rank;

import java.util.*;

public class LottoLine implements Iterable<LottoNumber>{
    public Set<LottoNumber> lottoLine;

    public LottoLine(){
        lottoLine = new HashSet<>(6);
    }

    public LottoLine(final Set<LottoNumber> lottoLine){
        this.lottoLine = lottoLine;
    }

    public Set<LottoNumber> getLottoLine() {
        return lottoLine;
    }

    public int getSize(){
        return lottoLine.size();
    }

    public void addNumber(LottoNumber n){
        lottoLine.add(n);
    }


    public boolean contains(LottoNumber lottoNumber){
        return lottoLine.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator(){
        return lottoLine.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoLine)) return false;
        LottoLine lottoLine1 = (LottoLine) o;
        return Objects.equals(getLottoLine(), lottoLine1.getLottoLine());
    }


    @Override
    public int hashCode() {
        return Objects.hash(lottoLine);
    }

    @Override
    public String toString() {

        List<LottoNumber> lottos = new ArrayList<>(lottoLine);
        Collections.sort(lottos);

        StringBuilder sb = new StringBuilder();
        lottos.forEach(sb::append);
        return sb.toString();
    }
}
