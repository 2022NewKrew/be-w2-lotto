package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private static final int ONE_LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator;
    private final List<Lotto> lottoList;
    private int lottoPrice;

    public LottoList() {
        lottoList = new ArrayList<>();
        lottoGenerator = new LottoGenerator();
    }

    public void createLottoList(int lottoPrice){
        this.lottoPrice = lottoPrice;
        int quantity = lottoPrice / ONE_LOTTO_PRICE;

        for(int i=0; i<quantity; i++){
            lottoList.add(lottoGenerator.createLotto());
        }
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
