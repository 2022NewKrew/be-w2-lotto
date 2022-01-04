package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int numOfPaper;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();


    public LottoGenerator(int numOfPaper){
        this.numOfPaper = numOfPaper;
    }

    public void generateLotto(){
        for(int i=0;i<numOfPaper;i++){
            LottoNumber lottonumber = new LottoNumber();
            lottoNumbers.add(lottonumber);
        }
    }

    public List<LottoNumber> getLottoPapers() { return lottoNumbers; }

}
