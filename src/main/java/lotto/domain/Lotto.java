package lotto.domain;

import lotto.view.LottoViewInput;
import lotto.view.LottoViewOutput;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoSetting.*;

public class Lotto {
    private LottoNumber lottoResult;
    private List<LottoNumber> lottos;
    private LottoViewOutput lottoViewOutput;

    public Lotto(Integer payment){
        lottos = new ArrayList<>();
        lottoViewOutput = new LottoViewOutput(this);

        Integer lottoCount = (payment / LOTTO_PRICE);

        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(createLotto());
        }
        lottoViewOutput.printLottoCount();
        lottoViewOutput.printAllLottos();
        lottoResult = new LottoNumber(LottoViewInput.lottoInputResult());
    }

    //getter
    public List<LottoNumber> getLottos() {
        return lottos;
    }



    private LottoNumber createLotto(){
        List<Integer> newLotto = new ArrayList<>();
        for(int i = 1 ; i <= LOTTO_NUMBER_RANGE ; i++){
            newLotto.add(i);
        }
        Collections.shuffle(newLotto);
        newLotto = newLotto.subList(0, LOTTO_LENGTH);
        newLotto.sort(Integer::compareTo);
        return new LottoNumber( newLotto );
    }
}
