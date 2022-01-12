package lotto.collections;

import java.util.*;

public class LottoLine {
    private Set<LottoNumber> lottoLine;

    public LottoLine(){
        this.lottoLine = new HashSet<>(6);
    }

    public LottoLine(final Set<LottoNumber> lottoLine){
        this.lottoLine = lottoLine;
    }

    public Set<LottoNumber> getLottoLine() {
        return this.lottoLine;
    }

    public void addNumber(LottoNumber n){
        this.lottoLine.add(n);
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
        StringBuilder sb = new StringBuilder();
        lottoLine.forEach(sb::append);
        return sb.toString();
    }
}
