package lotto.buyer;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumber;
import lotto.machine.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.*;

/**
 * 구매한 로또 리스트와
 * 로또 구매 / 당첨 번호 확인 메소드가 모여있는 클래스
 */
public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();                // 구매한 로또 리스트
    private final Map<LottoPrize, Integer> result = new EnumMap<>(Map.of(   // key : 등수 , value : 'key'등에 당첨된 로또 개수
            LottoPrize.FIFTH_PLACE,0,
            LottoPrize.FOURTH_PLACE,0,
            LottoPrize.THIRD_PLACE,0,
            LottoPrize.SECOND_PLACE,0,
            LottoPrize.FIRST_PLACE,0,
            LottoPrize.NONE, 0
    ));

    public final void buyLotto() {
        buyAutoLotto();
        buyManualLotto();
        OutputView.printLottoList(lottoList);
    }

    private void buyAutoLotto() {
        final int countLotto = InputView.inputPurchasePrice() / LOTTO_PRICE;    // 구매할 자동 로또 개수

        for (int i = 0; i < countLotto; i++) {
            lottoList.add(LottoMachine.generateLottoAuto());
        }
    }

    private void buyManualLotto() {
        InputView.inputLottoNumbersManually(lottoList);
    }

    /**
     * 구매한 로또들의 당첨 여부를 확인하는 메소드
     *
     * Map<LottoPrize, Integer> result 에 결과 저장
     */
    public final void checkAllLotto() {
        final LottoWinningNumber lottoWinningNumber = InputView.inputLastWinningNumbers();

        for (Lotto lotto : lottoList) {
            putResult(lottoWinningNumber.match(lotto));
        }

        OutputView.printResult(result);
        OutputView.printYield(calculateYield());
    }

    private void putResult(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.NONE) return; // 당첨 안 된 경우 (3개 미만 일치)
        result.put(lottoPrize, result.get(lottoPrize) + 1);
    }

    private int totalReward() {
        int totalReward = 0;

        for (LottoPrize lottoPrize : result.keySet()){
            totalReward += result.get(lottoPrize) * lottoPrize.getReward();
        }
        return totalReward;
    }

    private double calculateYield() { // 수익률 계산
        final int totalPurchase = lottoList.size() * LOTTO_PRICE;

        if (totalPurchase == 0)
            return 0;
        return (double) (totalReward() - totalPurchase) / totalPurchase * 100;
    }
}
