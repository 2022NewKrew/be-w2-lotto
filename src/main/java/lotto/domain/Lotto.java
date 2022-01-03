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
    private List<LottoWinner> lottoWinner;

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
        makeTotal();
        lottoViewOutput.printWinner();
    }

    //getter
    public List<LottoNumber> getLottos() {
        return lottos;
    }

    public List<LottoWinner> getLottoWinner() {
        return lottoWinner;
    }

    private Integer calculateMatchCount(LottoNumber curLotto){
        int resultIdx = 0;
        int curLottoIdx = 0;
        Integer matchCount = 0;

        while(resultIdx < lottoResult.num.size() && curLottoIdx < curLotto.num.size()){
            if(lottoResult.num.get(resultIdx).equals(curLotto.num.get(curLottoIdx))){
                resultIdx++;
                curLottoIdx++;
                matchCount++;
                continue;
            }
            if(lottoResult.num.get(resultIdx) < curLotto.num.get(curLottoIdx)){
                resultIdx++;
                continue;
            }

            if(lottoResult.num.get(resultIdx) > curLotto.num.get(curLottoIdx)){
                curLottoIdx++;
                continue;
            }
        }
        return matchCount;
    }

    void makeTotal(){
        lottoWinner = new ArrayList<>();

        for(int i = 0 ; i <= LOTTO_LENGTH ; i++){
            lottoWinner.add(new LottoWinner());
        }

        //calc
        for(int i = 0 ; i < lottos.size() ; i++){
            LottoNumber curLotto = lottos.get(i);
            lottoWinner.get(calculateMatchCount(curLotto)).addLottoNumber(curLotto);
        }

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
