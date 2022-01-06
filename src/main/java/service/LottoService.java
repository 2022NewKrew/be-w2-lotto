package service;

import domain.lotto.Lotto;
import domain.lotto.LottoGameInfo;
import domain.lotto.LottoGenerator;
import dto.LottoRequest;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<Lotto> createLotto(int money, List<LottoRequest> manualLottoRequests) {
        List<Lotto> lottos = manualLottoRequests.stream()
                .map(LottoRequest::toLotto)
                .collect(Collectors.toList());

        LottoGameInfo lottoGameInfo = new LottoGameInfo(money, lottos.size());
        lottos.addAll(LottoGenerator.generateLottos(lottoGameInfo.getAutomaticallyPurchaseQuantity()));
        return lottos;
    }
}
