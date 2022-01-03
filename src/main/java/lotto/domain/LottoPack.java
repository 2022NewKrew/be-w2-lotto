package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPack {
    private List lottos = new ArrayList();
    private static Lotto lotto = new Lotto();


    public LottoPack(int nLottos) {
        for(int i=0; i<nLottos;i++){
            List<Integer> lottoNums = lotto.getRandLotto();
            lottos.add(lottoNums);
        }
    }

    public List<List<Integer>> getNumList() {
        return lottos;
    }
}
