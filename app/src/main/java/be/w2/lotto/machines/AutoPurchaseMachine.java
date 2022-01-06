package be.w2.lotto.machines;

import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.lottos.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton
 */
public class AutoPurchaseMachine extends PurchaseMachine {

    private static AutoPurchaseMachine INSTANCE;

    private AutoPurchaseMachine() {
    }

    public static AutoPurchaseMachine getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AutoPurchaseMachine();
        return INSTANCE;
    }

    @Override
    protected void addNewLottosTo(List<Lotto> lottos, int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(createLottoRandomly());
        }
    }

    private Lotto createLottoRandomly() {
        List<Integer> randomNumbers = getListOfRandomNumber();
        Collections.sort(randomNumbers);
        List<LottoNumber> lottoNumbers = getLottoNumbersBy(randomNumbers);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> getListOfRandomNumber() {
        List<Integer> minToMaxNumOfLotto = getListOfMinToMaxNumOfLotto();
        Collections.shuffle(minToMaxNumOfLotto);
        List<Integer> numbers = minToMaxNumOfLotto.subList(0, Lotto.LENGTH);
        return numbers;
    }

    private List<Integer> getListOfMinToMaxNumOfLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUM_IN_LOTTO; i <= LottoNumber.MAX_NUM_IN_LOTTO; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private List<LottoNumber> getLottoNumbersBy(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return lottoNumbers;
    }
}
