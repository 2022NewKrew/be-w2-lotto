package service;

import domain.lotto.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.LottoConst.LOTTO_NUMBERS;
import static util.LottoConst.MAX_LOTTO_COUNT;

public class LottoGenerateService {

    public WinningLotto createWinningLotto(LottoOrder lottoOrder, int bonusNumber) {
        return new WinningLotto(lottoOrder.getLottoNumbers(), bonusNumber);
    }

    public List<Lotto> createLottos(LottoGameInfo info) {
        List<Lotto> lottos = info.getManualLottoOrders().stream()
                .map(this::generateOneLotto)
                .collect(Collectors.toList());

        lottos.addAll(generateLottosByQuantity(info.getAutomaticallyPurchaseQuantity()));
        return lottos;
    }

    private List<Lotto> generateLottosByQuantity(int requestQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int currentQuantity = 0; currentQuantity < requestQuantity; currentQuantity++) {
            Lotto lotto = createNewLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createNewLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, MAX_LOTTO_COUNT));
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }

    private Lotto generateOneLotto(LottoOrder lottoOrder) {
        return new Lotto(lottoOrder.getLottoNumbers());
    }
}
