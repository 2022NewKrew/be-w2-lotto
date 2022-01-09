package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> purchaseLottos(int count){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++){
            Lotto lotto = new Lotto();
            lotto.generateNumbers();
            lottos.add(lotto);
        }
        return lottos;
    }

}
