package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
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
    private final Map<Integer, Integer> result = new HashMap<>(Map.of(      // key : 맞은 개수, value : 일치하는 숫자가 key개인 로또 개수
            3,0,
            4,0,
            5,0,
            6,0,
            7,0
    ));
    private int purchaseAmount; // 구매 금액

    public final void start() {
        InputView.openScanner();

        purchaseAmount = InputView.getMoney();
        buyLotto(purchaseAmount);
        OutputView.printLottoList(lottoList);

        checkAllLotto();
        OutputView.printResult(result);
        OutputView.printYield(calculateYield());

        InputView.closeScanner();
    }

    /**
     * 구매 금액 (price)에 해당하는 로또를 생성해 반환하는 메소드
     *
     * @param price : 구매 금액
     */
    private void buyLotto(final int price) {
        final int countLotto = price / LOTTO_PRICE;

        OutputView.printCountLotto(countLotto);
        for(int i = 0; i < countLotto; i++) {
            lottoList.add(LottoMachine.generateLotto());
        }
    }

    private void checkAllLotto() {
        final List<Integer> winningNumbers = InputView.getLastWinningNumbers();
        final Integer bonusBall = InputView.getBonusBall();

        for(Lotto lotto : lottoList) {
            int matchCount = lotto.match(winningNumbers, bonusBall);
            putResult(matchCount);
        }
    }

    private void putResult(final int matchCount) {
        if(matchCount < 3) return;
        result.put(matchCount, result.get(matchCount) + 1);
    }

    private int totalReward() {
        int totalReward = 0;
        for(Integer key : result.keySet()){
            totalReward += result.get(key) * LottoPrize.of(key).getReward();
        }
        return totalReward;
    }

    private double calculateYield() { // 수익률 계산
        return (double) (totalReward() - purchaseAmount) / purchaseAmount * 100;
    }
}
