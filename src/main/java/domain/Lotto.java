package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    Lotto() {
        setUpRandomLotto();
    }

    private void setUpRandomLotto() {
        List<Integer> allLottoNumbers = new LottoNumbers().getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        numbers = allLottoNumbers.subList(0,6);
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
