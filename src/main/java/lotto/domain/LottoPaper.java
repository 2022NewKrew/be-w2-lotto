package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {
    public int inputPrice;
    public int numOfNumbers;
    public List<LottoNumber> lottoNumbers = new ArrayList<>();

    public void add(LottoNumber ln){
        lottoNumbers.add(ln);
    }
}
