package com.david.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGenerator {

    private Lotto generateLotto() {
        List<Integer> allLottoNumber = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(allLottoNumber);
        List<Integer> lottoNumber = allLottoNumber.subList(0, 6);
        return new Lotto(lottoNumber);
    }

    private Lotto generateLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    public List<Lotto> generateLottoList(int countOfLotto, int manualCount, List<List<Integer>> manualLottoList) {
        Stream<Lotto> manualLottoStream = manualLottoList.stream().map(this::generateLotto);
        int autoCount = countOfLotto - manualCount;
        Stream<Lotto> autoLottoStream = Stream.generate(this::generateLotto).limit(autoCount);
        return Stream.concat(manualLottoStream, autoLottoStream).collect(Collectors.toList());
    }
}
