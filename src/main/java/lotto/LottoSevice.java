package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSevice {

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
