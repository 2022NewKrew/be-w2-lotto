package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private static final List<LottoNumber> numbers = new ArrayList<>(45);

    static {
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++)
            numbers.add(LottoNumber.from(i));
    }

    public static void buyLotto(List<Lotto> lottoList) {
        final int numberOfAutoLotto = InputView.inputPurchasePrice() / LOTTO_PRICE;    // 구매할 자동 로또 개수

        for (int i = 0; i < numberOfAutoLotto; i++) { // 자동 구매
            lottoList.add(LottoMachine.generateAutoLotto());
        }

        final int numberOfManualLotto = InputView.inputManualLottoCount();

        for (int i = 0; i < numberOfManualLotto; i++) { // 수동 구매
            lottoList.add(LottoMachine.generateManualLotto());
        }
    }

    public static Lotto generateAutoLotto() {
        Collections.shuffle(numbers);
        return new Lotto(new ArrayList<>(numbers.subList(0, Lotto.LOTTO_NUMBERS_COUNT)));
    }

    public static Lotto generateManualLotto() {
        return new Lotto(InputView.inputLottoNumbersManually());
    }
}
