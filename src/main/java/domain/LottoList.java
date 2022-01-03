package domain;

import domain.Lotto;
import domain.LottoConst;
import domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final LottoGenerator lottoGenerator;
    private final List<Lotto> lottoList;

    public LottoList() {
        lottoList = new ArrayList<>();
        lottoGenerator = new LottoGenerator();
    }

    public void createLottoList(int price){
        int quantity = price / LottoConst.LOTTO_PRICE;

        for(int i=0; i<quantity; i++){
            lottoList.add(lottoGenerator.createLotto());
        }
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
