package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.generator.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private LottoGenerator getLottoGenerator() {
        return new LottoAutoGenerator();
    }

    public List<Lotto> purchaseLottos(int count){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++){
            lottos.add(getLottoGenerator().generateLotto());
        }
        return lottos;
    }

}
