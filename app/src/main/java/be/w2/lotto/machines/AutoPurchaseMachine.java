package be.w2.lotto.machines;

import be.w2.lotto.lottos.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoPurchaseMachine extends PurchaseMachine {

    @Override
    protected void addNewLottos(List<Lotto> lottos, int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(createLottoRandomly());
        }
    }

    private Lotto createLottoRandomly() {
        List<Integer> randomNumbers = getListOfRandomNumber(Lotto.LENGTH);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

    private List<Integer> getListOfRandomNumber(int length) {
        List<Integer> oneToNinetyNine = getListOfMinToMaxNumOfLotto();
        Collections.shuffle(oneToNinetyNine);
        List<Integer> numbers = oneToNinetyNine.subList(0, Lotto.LENGTH);
        return numbers;
    }

    private List<Integer> getListOfMinToMaxNumOfLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = Lotto.MIN_NUM_IN_LOTTO; i <= Lotto.MAX_NUM_IN_LOTTO; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
