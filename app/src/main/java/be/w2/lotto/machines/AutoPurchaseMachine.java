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
        List<LottoNumber> randomLottoNumbers = getListOfLottoNumberRandomly();
        Collections.sort(randomLottoNumbers);
        return new Lotto(randomLottoNumbers);
    }

    private List<LottoNumber> getListOfLottoNumberRandomly() {
        List<LottoNumber> allLottoNumber = getAllLottoNumber();
        Collections.shuffle(allLottoNumber);
        List<LottoNumber> numbers = allLottoNumber.subList(0, Lotto.LENGTH);
        return numbers;
    }

    private List<LottoNumber> getAllLottoNumber() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUM_IN_LOTTO; i <= LottoNumber.MAX_NUM_IN_LOTTO; i++) {
            numbers.add(LottoNumber.of(i));
        }
        return numbers;
    }
}
