package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoSetting.LOTTO_LENGTH;

public class LottoNumber {
    public List<Integer> num;

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
}
