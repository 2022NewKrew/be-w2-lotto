package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WiningLotto;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.LottoManualGenerator;
import lotto.domain.generator.WinningLottoGenerator;
import lotto.result.LottoRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private LottoGenerator getLottoGenerator() {
        return new LottoAutoGenerator();
    }

    private LottoGenerator getLottoGenerator(List<Integer> userNumber) {
        return new LottoManualGenerator(userNumber);
    }

    private LottoGenerator getLottoGenerator(List<Integer> userNumber, int bonusBall) {
        return new WinningLottoGenerator(userNumber, bonusBall);
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

    public Map<LottoRank, Integer> createLottoResults(List<Lotto> lottos, List<Integer> lastWeekLottoNumbers, int bonusBall) {
        Map<LottoRank, Integer> results = new HashMap<>();
        WiningLotto winingLotto = (WiningLotto)getLottoGenerator(lastWeekLottoNumbers, bonusBall).generateLotto();
        for (Lotto lotto : lottos){
            LottoRank result = winingLotto.matchLotto(lotto);
            results.put(result, results.get(results) + 1);
        }
        return results;
    }

}
