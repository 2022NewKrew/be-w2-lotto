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
    private List<Integer> lottoElement;

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
        int matchCount = 0;

        while(resultIdx < lottoResult.num.size() && curLottoIdx < curLotto.num.size()){
            if(lottoResult.num.get(resultIdx).equals(curLotto.num.get(curLottoIdx))){
                resultIdx++; curLottoIdx++; matchCount++; continue;
            }
            int garbageVariable = ((lottoResult.num.get(resultIdx) < curLotto.num.get(curLottoIdx)) ? resultIdx++ : curLottoIdx++ ) ;
        }
        return matchCount;
    }

    void makeTotal(){
        //init lottoWinner Objects
        lottoWinner = new ArrayList<>();

        for(int i = 0 ; i <= LOTTO_LENGTH ; i++){
            lottoWinner.add(new LottoWinner());
        }

        //add win numbers to lottoWinner
        for(int i = 0 ; i < lottos.size() ; i++){
            LottoNumber curLotto = lottos.get(i);
            lottoWinner.get(calculateMatchCount(curLotto)).addLottoNumber(curLotto);
        }

    }

    private void initLottoElement(){
        for(int i = 1 ; i <= LOTTO_NUMBER_RANGE ; i++){
            lottoElement.add(i);
        }
    }

    private LottoNumber createLotto(){
        //initialize only once
        if(lottoElement == null){
            lottoElement = new ArrayList<>();
            initLottoElement();
        }

        Collections.shuffle(lottoElement);
        List<Integer> newLotto = lottoElement.subList(0, LOTTO_LENGTH);
        newLotto.sort(Integer::compareTo);
        return new LottoNumber( newLotto );
    }
}
