package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.LottoManualGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private LottoGenerator getLottoGenerator() {
        return new LottoAutoGenerator();
    }

    private LottoGenerator getLottoGenerator(List<Integer> userNumber) {
        return new LottoManualGenerator(userNumber);
    }

    public List<Lotto> purchaseLottos(int count){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++){
            lottos.add(getLottoGenerator().generateLotto());
        }
        return lottos;
    }

    public List<Lotto> purchaseLottoByUserNumbers(List<List<Integer>> userNumbers){
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> userNumber : userNumbers){
            lottos.add(getLottoGenerator(userNumber).generateLotto());
        }
        return lottos;
    }

}
