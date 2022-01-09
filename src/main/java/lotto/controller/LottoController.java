package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WiningLotto;
import lotto.result.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.vo.LottoVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<LottoVO> purchaseLottos(int count) {
        return lottoService.purchaseLottos(count)
                .stream().map(LottoVO::new).collect(Collectors.toList());
    }

    public List<LottoVO> purchaseLottoByUserNumbers(List<List<Integer>> userNumbers){
        return lottoService.purchaseLottoByUserNumbers(userNumbers)
                .stream().map(LottoVO::new).collect(Collectors.toList());
    }

    public Map<LottoResult, Integer> createLottoResults(List<LottoVO> lottos, List<Integer> lastWeekLottoNumbers, int bonusBall) {
        return lottoService.createLottoResults(lottos.stream().map(lottoVO -> new Lotto(lottoVO.getNumbers())).collect(Collectors.toList()), lastWeekLottoNumbers, bonusBall);
    }

}
