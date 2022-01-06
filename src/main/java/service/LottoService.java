package service;

import domain.lotto.Lotto;
import domain.lotto.LottoGameInfo;
import domain.lotto.LottoGenerator;
import domain.lotto.LottoOrder;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<Lotto> createLotto(int money, List<LottoOrder> manualLottoOrders) {
        List<Lotto> lottos = manualLottoOrders.stream()
                .map(LottoOrder::toLotto)
                .collect(Collectors.toList());

        LottoGameInfo lottoGameInfo = new LottoGameInfo(money, lottos.size());
        lottos.addAll(LottoGenerator.generateLottos(lottoGameInfo.getAutomaticallyPurchaseQuantity()));
        return lottos;
    }
}
