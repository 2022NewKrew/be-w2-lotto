package domain;

import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final LottoList lottoList;
    private final LottoGenerator lottoGenerator;


    public LottoMachine() {
        lottoList = new LottoList();
        lottoGenerator = new LottoGenerator();
    }

    public void autoLottoList(int lottoPrice){
        int quantity = lottoPrice / LottoConst.ONE_LOTTO_PRICE;

        for(int i=0; i<quantity; i++){
            lottoList.addLotto(lottoGenerator.createLotto(), LottoConst.AUTO_CREATE);
        }
    }

    public void manualLottoList(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
//            Collections.sort(lotto.getLotto());
            lottoList.addLotto(lotto, LottoConst.MANUAL_CREATE);
        }
    }

    public LottoList getLottoList(){
        return lottoList;
    }
}
