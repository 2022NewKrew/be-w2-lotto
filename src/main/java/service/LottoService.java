package service;

import domain.Lotto;

import java.util.ArrayList;

import static utils.Symbol.LOTTO_PRICE;

public class LottoService {
    private ArrayList<Lotto> lottoList = new ArrayList<>();

    public LottoService(int purchaseAmount, int manualLottoCount){
        int automaticLottoCount = purchaseAmount / LOTTO_PRICE - manualLottoCount;
        AutomaticGenerator automaticGenerator = new AutomaticGenerator();

        for(int i = 0; i < automaticLottoCount; i++){
            lottoList.add(generate(automaticGenerator));
        }
    }

    public Lotto generate(LottoGenerator lottoGenerator){
        return lottoGenerator.generate();
    }

    public ArrayList<Lotto> getLottos(){
        return lottoList;
    }
}
