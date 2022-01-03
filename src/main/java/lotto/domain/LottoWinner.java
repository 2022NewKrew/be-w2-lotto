package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoSetting.LOTTO_LENGTH;

public class LottoWinner {
    List<LottoNumber> winner;

    public LottoWinner(){
        winner = new ArrayList<>();
    }

    public void addLottoNumber(LottoNumber lottoNumber){
        winner.add(lottoNumber);
    }
}
