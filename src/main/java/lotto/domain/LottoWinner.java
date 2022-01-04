package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoSetting.LOTTO_LENGTH;

public class LottoWinner { //삭제예정
    List<LottoNumber> winner;

    public LottoWinner(){
        winner = new ArrayList<>();
    }

    public List<LottoNumber> getWinner() {
        return winner;
    }

    public void addLottoNumber(LottoNumber lottoNumber){
        winner.add(lottoNumber);
    }
}
