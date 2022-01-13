package lotto.collections;

import lotto.utils.LottoNumberPool;

import java.util.*;

public class LottoLine implements Iterable<LottoNumber>{
    public final Set<LottoNumber> lottoLine;

    public LottoLine(final Set<LottoNumber> lottoLine ) throws IllegalArgumentException{
        if (lottoLine.size() !=6){
            throw new IllegalArgumentException("Lotto 번호 개수는 6개 입력해 주세요.\n");
        }
        this.lottoLine = lottoLine;
    }

    public Set<LottoNumber> getLottoLine() {
        return lottoLine;
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
