package be.w2.lotto.machines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoPurchaseMachine extends PurchaseMachine {

    @Override
    protected void addNewLottos(List<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            lottos.add(createLottoRandomly());
        }
    }

    private Lotto createLottoRandomly() {
        List<Integer> randomNumbers = getListOfRandomNumber(Lotto.LENGTH);
        return new Lotto(randomNumbers);
    }

    private List<Integer> getListOfRandomNumber(int length) {
        List<Integer> oneToNinetyNine = getListOfOneToNinetyNine();
        Collections.shuffle(oneToNinetyNine);
        List<Integer> numbers = oneToNinetyNine.subList(0, Lotto.LENGTH);
        return numbers;
    }

    private List<Integer> getListOfOneToNinetyNine() {
        List<Integer> numbers = new ArrayList<>(100);
        for(int i = 1; i<100;i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
