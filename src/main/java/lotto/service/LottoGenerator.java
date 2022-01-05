package lotto.service;

import lotto.service.domain.LottoNumbers;
import lotto.util.LottoConstantValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> allNumbers = IntStream
                                        .rangeClosed(LottoConstantValue.MIN_NUMBER, LottoConstantValue.MAX_NUMBER)
                                        .boxed()
                                        .collect(Collectors.toList());

    public static LottoNumbers autoGenerate(){
        Collections.shuffle(allNumbers);

        List<Integer> pickedNumbers = new ArrayList<>(allNumbers.subList(0,LottoConstantValue.NUMBER_OF_PICK));
        Collections.sort( pickedNumbers );
        return new LottoNumbers(pickedNumbers);
    }
}
