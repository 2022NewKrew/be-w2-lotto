package step5.model.service;

import step5.model.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step5.utils.CommonConstants.LOTTO_PRICE;

public interface LottosService {
    Lottos selectAllLottosFromRepository();
    void insertLottosToRepository(Lottos lottos);

    default Lottos makeLottos(String moneyForBuy, String manualLottosStr) {
        int lottosQuantity = getLottosQuantity(moneyForBuy);
        List<Lotto> manualLottos = divideManualLottosStr(manualLottosStr);
        return new Lottos(manualLottos, getAutoLottosQuantity(manualLottos, lottosQuantity));
    }

    default int getLottosQuantity(String moneyForBuyStr) {
        int moneyForBuy = Integer.parseInt(moneyForBuyStr);
        int lottosQuantity = moneyForBuy / LOTTO_PRICE;

        if (moneyForBuy < LOTTO_PRICE || lottosQuantity * LOTTO_PRICE != moneyForBuy) {
            throw new NumberFormatException("잘못된 금액이 입력되었습니다.");
        }

        return lottosQuantity;
    }

    default List<Lotto> divideManualLottosStr(String manualLottosStr) {
        return Arrays.stream(manualLottosStr.split("\r?\n"))
                .map(Lotto::chooseAutoOrManual)
                .collect(Collectors.toList());
    }

    default int getAutoLottosQuantity(List<Lotto> manualLottos, int lottosQuantity) {
        if (manualLottos.size() > lottosQuantity) {
            throw new NumberFormatException("수동 로또의 개수가 구매할 로또의 개수보다 많습니다.");
        }

        return lottosQuantity - manualLottos.size();
    }

    default Lottos joinLottosBetweenRepoAndInserted(String moneyForBuy, String manualLottos) {
        Lottos lottos = selectAllLottosFromRepository();
        Lottos newLottos = makeLottos(moneyForBuy, manualLottos);

        insertLottosToRepository(newLottos);
        lottos.addLottos(newLottos);

        return lottos;
    }
}
