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
}
