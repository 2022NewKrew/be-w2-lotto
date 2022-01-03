package lotto.domain;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoSetting.*;

public class Lotto {
    private List<LottoNumber> lottos;

    public Lotto(Integer payment){
        lottos = new ArrayList<>();

        Integer lottoCount = (payment / LOTTO_PRICE);

        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(createLotto());
        }
    }


    private LottoNumber createLotto(){
        List<Integer> newLotto = new ArrayList<>();
        for(int i = 1 ; i <= 45 ; i++){
            newLotto.add(i);
        }
        Collections.shuffle(newLotto);
        newLotto = newLotto.subList(0, LOTTO_LENGTH - 1);
        newLotto.sort(Integer::compareTo);
        return new LottoNumber( newLotto );
    }
}
