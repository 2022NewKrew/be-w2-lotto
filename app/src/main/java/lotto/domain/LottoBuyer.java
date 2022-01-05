package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 구매한 로또 리스트와
 * 로또 구매 / 당첨 번호 확인 메소드가 모여있는 클래스
 */
public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();                // 구매한 로또 리스트
    private final Map<LottoPrize, Integer> result = new HashMap<>(Map.of(   // key : 등수 , value : 'key'등에 당첨된 로또 개수
            LottoPrize.FIFTH_PLACE,0,
            LottoPrize.FOURTH_PLACE,0,
            LottoPrize.THIRD_PLACE,0,
            LottoPrize.SECOND_PLACE,0,
            LottoPrize.FIRST_PLACE,0
    ));

    public final void start() {
        InputView.openScanner();

        buyLotto(InputView.getPurchaseAmount());
        InputView.getLottoNumbersManually(lottoList);

        OutputView.printLottoList(lottoList);

        checkAllLotto();
        OutputView.printResult(result);
        OutputView.printYield(calculateYield());

        InputView.closeScanner();
    }

    /**
     * 구매 금액 (purchaseAmount)에 해당하는 로또를 생성해 반환하는 메소드
     *
     * @param purchaseAmount : 구매 금액
     */
    private void buyLotto(final int purchaseAmount) {
        final int countLotto = purchaseAmount / LOTTO_PRICE;

        for(int i = 0; i < countLotto; i++) {
            lottoList.add(LottoMachine.generateLottoAuto());
        }
    }

    /**
     * 구매한 로또들의 당첨 여부를 확인하는 메소드
     *
     * Map<LottoPrize, Integer> result 에 결과 저장
     */
    private void checkAllLotto() {
        final List<Integer> winningNumbers = InputView.getLastWinningNumbers();
        final Integer bonusBall = InputView.getBonusBall();

        for(Lotto lotto : lottoList) {
            int matchCount = lotto.match(winningNumbers, bonusBall);
            putResult(matchCount);
        }
    }

    private void putResult(final int matchCount) {
        if(matchCount < 3) return; // 3개 미만 일치는 무시
        result.put(LottoPrize.of(matchCount), result.get(LottoPrize.of(matchCount)) + 1);
    }

    private int totalReward() {
        int totalReward = 0;

        for(LottoPrize lottoPrize : result.keySet()){
            totalReward += result.get(lottoPrize) * lottoPrize.getReward();
        }
        return totalReward;
    }

    private double calculateYield() { // 수익률 계산
        final int totalPurchase = lottoList.size() * LOTTO_PRICE;

        if(totalPurchase == 0)
            return 0;
        return (double) (totalReward() - totalPurchase) / totalPurchase * 100;
    }
}
