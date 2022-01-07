package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  LottoMachine 객체를 통해 로또를 구매할 수 있습니다.
 *  로또를 구매하면 (buyLotto),
 *  자동로또와 수동로또를 생성해서 반환합니다. (generateAutoLotto / generateManualLotto)
 */
public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private static final List<LottoNumber> numbers = new ArrayList<>(LottoNumber.MAX_NUMBER);
    private static LottoMachine INSTANCE;

    static {
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++)
            numbers.add(LottoNumber.from(i));
    }

    private LottoMachine() {
    }

    public static synchronized LottoMachine getInstance() {
        if (INSTANCE == null) { INSTANCE = new LottoMachine(); }
        return INSTANCE;
    }

    public void buyAutoLotto(List<Lotto> lottoList, int purchasePrice) {
        final int numberOfAutoLotto = purchasePrice / LOTTO_PRICE; // 구매할 자동 로또 개수

        for (int i = 0; i < numberOfAutoLotto; i++) { // 자동 구매
            lottoList.add(generateAutoLotto());
        }
    }

    public void buyManualLotto(List<Lotto> lottoList, int numberOfManualLotto) {
        for (int i = 0; i < numberOfManualLotto; i++) { // 수동 구매
            lottoList.add(generateManualLotto());
        }
    }

    private Lotto generateAutoLotto() {
        Collections.shuffle(numbers);
        return new Lotto(new ArrayList<>(numbers.subList(0, Lotto.LENGTH)));
    }

    private Lotto generateManualLotto() {
        return new Lotto(InputView.inputLottoNumbersManually());
    }
}
