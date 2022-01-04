package service;

import domain.Lotto;

import java.util.ArrayList;

public class OwnLotto {
    private ArrayList<Lotto> lottoList = new ArrayList<>();

    public OwnLotto(int purchaseAmount, int manualLottoCount){
        int automaticLottoCount = purchaseAmount/1000 - manualLottoCount;
        AutomaticGenerator automaticGenerator = new AutomaticGenerator();

        for(int i = 0; i < automaticLottoCount; i++){
            lottoList.add(generate(automaticGenerator));
        }
    }

    public Lotto generate(LottoGenerator lottoGenerator){
        return lottoGenerator.generate();
    }

    public void printOwnLottoList(){
        int lottoListSize = lottoList.size();
        System.out.println(lottoListSize+"개를 구매했습니다.");
        for(int i = 0; i < lottoListSize; i++){
            Lotto lotto = lottoList.get(i);
            System.out.println(lotto);
        }
    }
}
