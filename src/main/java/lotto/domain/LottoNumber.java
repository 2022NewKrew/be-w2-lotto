package lotto.domain;

import lotto.view.LottoViewInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoSetting.*;

public class LottoNumber {
    public List<Integer> num;
    static private List<Integer> lottoElement;

    public LottoNumber(List<Integer> newNum){
        num = new ArrayList<>();
        for(int i = 0; i < newNum.size() && i < LOTTO_LENGTH; i++){
            num.add(newNum.get(i));
        }
    }


    public Integer calculateMatchCount(LottoNumber resultLotto){
        int resultIdx = 0;
        int curLottoIdx = 0;
        int matchCount = 0;

        while(resultIdx < resultLotto.num.size() && curLottoIdx < this.num.size()){
            if(resultLotto.num.get(resultIdx).equals(this.num.get(curLottoIdx))){
                resultIdx++; curLottoIdx++; matchCount++; continue;
            }
            int garbageVariable = ((resultLotto.num.get(resultIdx) < this.num.get(curLottoIdx)) ? resultIdx++ : curLottoIdx++ ) ;
        }
        return matchCount;
    }


    static private void initLottoElement(){
        for(int i = LOTTO_NUMBER_RANGE_START ; i <= LOTTO_NUMBER_RANGE_LAST ; i++){
            lottoElement.add(i);
        }
    }


    static public LottoNumber createRandomLotto(boolean isPrinting){
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

    static public LottoNumber createUserMakeLotto(Boolean isPrinting){
        List<Integer> newLotto = LottoViewInput.lottoInputResult(() -> {if(isPrinting) System.out.println("수동으로 구매할 번호를 입력해 주세요.");});
        newLotto.sort(Integer::compareTo);
        return new LottoNumber( newLotto );
    }

}
