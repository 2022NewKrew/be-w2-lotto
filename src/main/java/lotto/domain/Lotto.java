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
    private LottoResult lottoResult;
    private List<LottoNumber> lottos;
    private List<LottoWinner> lottoWinner;
    private List<Integer> lottoElement;

    public Lotto(){
        lottos = new ArrayList<>();
    }

    //getter
    public List<LottoNumber> getLottos() {
        return lottos;
    }

    public List<LottoWinner> getLottoWinner() {
        return lottoWinner;
    }

    public Long getPayment(){
        return Long.valueOf(lottos.size() * LOTTO_PRICE) ;
    }

    public Long getEarning(){
        Long totalEarning = Long.valueOf(0);

        for(int correctCount = 0 ; correctCount <= LOTTO_LENGTH ; correctCount++){
            totalEarning += Long.valueOf(LOTTO_WINNER_PRIZE.get(correctCount)) * lottoWinner.get(correctCount).getWinner().size();
        }

        return totalEarning;
    }

    public void setLottoResult(LottoNumber lottoNumber, Integer bonusNumber) {
        lottoResult = new LottoResult();
        lottoResult.setLottoNumber(lottoNumber);
        lottoResult.setBonusNumber(bonusNumber);
    }

    public void addRandomLottos(Integer lottoCount){
        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(createRandomLotto()); //lottoCount만큼 랜덤으로 로또를 생성
        }
    }


    private Integer calculateMatchCount(LottoNumber curLotto){
        int resultIdx = 0;
        int curLottoIdx = 0;
        int matchCount = 0;

        while(resultIdx < lottoResult.getLottoNumber().num.size() && curLottoIdx < curLotto.num.size()){
            if(lottoResult.getLottoNumber().num.get(resultIdx).equals(curLotto.num.get(curLottoIdx))){
                resultIdx++; curLottoIdx++; matchCount++; continue;
            }
            int garbageVariable = ((lottoResult.getLottoNumber().num.get(resultIdx) < curLotto.num.get(curLottoIdx)) ? resultIdx++ : curLottoIdx++ ) ;
        }
        return matchCount;
    }

    public void makeTotal(){
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

    private LottoNumber createRandomLotto(){
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
