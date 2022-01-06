package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoList {
    private final LottoGenerator lottoGenerator;
    private final List<Lotto> lottoList;
    private int lottoPrice;
    private int manualCount;

    public LottoList() {
        lottoList = new ArrayList<>();
        lottoGenerator = new LottoGenerator();
        lottoPrice = 0;
        manualCount = 0;
    }

    public void createAutoLottoList(int lottoPrice){
        this.lottoPrice += lottoPrice;
        int quantity = lottoPrice / LottoConst.ONE_LOTTO_PRICE;

        for(int i=0; i<quantity; i++){
            lottoList.add(lottoGenerator.createLotto());
        }
    }

    public void createManualLottoList(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getLotto());
            lottoPrice += LottoConst.ONE_LOTTO_PRICE;
            manualCount++;
            lottoList.add(lotto);
        }
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public int getAutoCount(){
        return getCount() - manualCount;
    }

    public int getManualCount(){
        return manualCount;
    }

    public int getCount(){
        return lottoList.size();
    }
}
