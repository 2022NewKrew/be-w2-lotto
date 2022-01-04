package com.kakao.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        makeAutoLotto();
    }

    public List<Integer> getLotto() { return lotto; }

    private void makeAutoLotto() {
        List<Integer> LOTTO_NUMS = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(LOTTO_NUMS);
        lotto = LOTTO_NUMS.subList(0, 6);
        Collections.sort(lotto);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
