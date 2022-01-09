package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.vo.LottoVO;

import java.util.List;
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

}
