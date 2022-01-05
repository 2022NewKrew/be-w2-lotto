package com.david.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public List<Integer> generateLottoNumber() {
        List<Integer> allLottoNumber = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(allLottoNumber);
        List<Integer> lottoNumber = allLottoNumber.subList(0, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
