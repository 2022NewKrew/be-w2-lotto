package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();
    private final Map<Integer, Integer> result = new HashMap<>();

    public final void start() {
        Input.openScanner();
        buyLotto(Input.getMoney());
        OutputView.printLottoList(lottoList);
        checkAllLotto();
        OutputView.printResult(result);
        Input.closeScanner();
    }

    /**
     * 구매 금액 (price)에 해당하는 로또를 생성해 반환하는 메소드
     *
     * @param price : 구매 금액
     */
    public final void buyLotto(final int price) {
        final int countLotto = price / LOTTO_PRICE;

        OutputView.printCountLotto(countLotto);
        for(int i = 0; i < countLotto; i++) {
            lottoList.add(LottoMachine.generateLotto());
        }
    }

    public final void checkAllLotto() {
        final List<Integer> winningNumbers = Input.getLastWinningNumbers();
        for(Lotto lotto : lottoList) {
            int matched = lotto.match(winningNumbers);
            putResult(matched);
        }
    }

    private final void putResult(int key) {
        if(key < 3) return;

        if(!result.containsKey(key)){
            result.put(key, 1);
            return;
        }
        result.put(key, result.get(key) + 1);
    }
}
