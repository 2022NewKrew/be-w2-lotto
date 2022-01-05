package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private static final int ONE_LOTTO_PRICE = 1000;

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
        int quantity = lottoPrice / ONE_LOTTO_PRICE;

        for(int i=0; i<quantity; i++){
            lottoList.add(lottoGenerator.createLotto());
        }
    }

    public void createManualLottoList(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            lottoPrice += ONE_LOTTO_PRICE;
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
        return lottoList.size() - manualCount;
    }

    public int getManualCount(){
        return manualCount;
    }
}
