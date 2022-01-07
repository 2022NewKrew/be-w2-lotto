package domain.Generator;

import domain.Lotto;

import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator extends LottoGenerator {

    public  Lotto generateLotto(){
        LottoBox lottoBox = LottoBox.getInstance();
        List<Integer> lottoList =  lottoBox.getCopiedLottoList();
        return new Lotto(shuffleAndSlice(lottoList));
    }
    private List<Integer> shuffleAndSlice(List<Integer> lottoList){
        Collections.shuffle(lottoList);
        return lottoList.subList(0,NUM_OF_LOTTO);
    }
}
