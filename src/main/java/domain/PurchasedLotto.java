package domain;

import java.util.Collections;
import java.util.List;

public class PurchasedLotto implements Lotto {
    private List<Integer> numbers;

    PurchasedLotto() {
        pickRandomNumbers();
    }

    PurchasedLotto(List<Integer> manualNumbers) {
        pickManualNumbers(manualNumbers);
    }

    private void pickRandomNumbers() {
        List<Integer> allLottoNumbers = new LottoNumbers().getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        numbers = allLottoNumbers.subList(0,6);
        Collections.sort(numbers);
    }

    private void pickManualNumbers(List<Integer> manualNumbers) {
        numbers = manualNumbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
