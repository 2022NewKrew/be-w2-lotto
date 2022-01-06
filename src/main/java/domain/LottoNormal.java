package domain;

import java.util.List;

public class LottoNormal extends Lotto {

    public LottoNormal(List<Integer> numbers) {
        super(numbers);
        validationOfkNumbers();
    }

}
