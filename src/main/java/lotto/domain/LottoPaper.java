package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 종이 한 장을 의미하는 클래스
 */
public class LottoPaper {
    public int inputPrice;
    public int numOfNumbers;
    public List<LottoNumber> lottoNumbers = new ArrayList<>();

    public void add(LottoNumber ln){
        lottoNumbers.add(ln);
    }
}
