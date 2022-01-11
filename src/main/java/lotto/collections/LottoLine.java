package lotto.collections;

import java.util.List;

public class LottoLine {
    private List<LottoNumber> lottoLine;

    public void lottoLine(final List<LottoNumber> lottoLine){
        this.lottoLine = lottoLine;
    }

    @Override
    public String toString() {
        return this.lottoLine.stream().toString();
    }
}
