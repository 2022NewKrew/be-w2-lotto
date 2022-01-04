package com.david.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> allLottoNumber = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    private final List<Integer> lottoNumber = new ArrayList<>();

    public Lotto() {
        Collections.shuffle(allLottoNumber);
        for (int i = 0; i < 6; i++) {
            int number = allLottoNumber.get(i);
            lottoNumber.add(number);
        }
        Collections.sort(lottoNumber);
    }

    public int calculateCountOfMatch(List<Integer> winningNumber) {
        return (int) lottoNumber.stream().filter(winningNumber::contains).count();
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
