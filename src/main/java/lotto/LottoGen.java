package main.java.lotto;

import main.java.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;

public class LottoGen {
    private ArrayList<Integer> lottoSet;

    public LottoGen(){
        lottoSet = new ArrayList<Integer>();
        for(int i=1;i<46;i++){
            lottoSet.add(i);
        }
    }

    public Lotto makeLotto(){
        Lotto tmpLotto = new Lotto();
        Collections.shuffle(lottoSet);
        for(int i=0;i<6;i++){
            tmpLotto.addLotto(lottoSet.get(i));
        }
        Collections.sort(tmpLotto.getLotto());
        return tmpLotto;
    }
}
