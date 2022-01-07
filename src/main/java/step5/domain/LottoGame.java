package step5.domain;

import step5.domain.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step5.utils.CommonConstants.LOTTO_PRICE;

public class LottoGame {
    public static Lottos makeLottos(String moneyForBuy, String manualLottosStr) {
        int lottosQuantity = getLottosQuantity(moneyForBuy);
        List<Lotto> manualLottos = divideManualLottosStr(manualLottosStr);
        return new Lottos(manualLottos, getAutoLottosQuantity(manualLottos, lottosQuantity));
    }

    private static int getLottosQuantity(String moneyForBuyStr) {
        int moneyForBuy = Integer.parseInt(moneyForBuyStr);
        int lottosQuantity = moneyForBuy / LOTTO_PRICE;

        if (moneyForBuy < LOTTO_PRICE || lottosQuantity * LOTTO_PRICE != moneyForBuy) {
            throw new NumberFormatException("잘못된 금액이 입력되었습니다.");
        }

        return lottosQuantity;
    }

    private static List<Lotto> divideManualLottosStr(String manualLottosStr) {
        return Arrays.stream(manualLottosStr.split("\r?\n"))
                .map(Lotto::chooseAutoOrManual)
                .collect(Collectors.toList());
    }

    private static int getAutoLottosQuantity(List<Lotto> manualLottos, int lottosQuantity) {
        if (manualLottos.size() > lottosQuantity) {
            throw new NumberFormatException("수동 로또의 개수가 구매할 로또의 개수보다 많습니다.");
        }

        return lottosQuantity - manualLottos.size();
    }

    public static Matches startMatch(Lottos lottos, String resultStr, String bonusNumberStr) {
        Result result = new Result(resultStr);
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(bonusNumberStr), result);
        Matches matches = new Matches();
        matches.matchLottosWithResult(lottos, result, bonusNumber);

        return matches;
    }
}
