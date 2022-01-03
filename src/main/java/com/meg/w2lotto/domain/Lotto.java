package com.meg.w2lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int NUMCOUNT = 6;
    public static final int NUMRANGE = 45;
    public static final int COST = 1000;
    private List<Integer> numbers;

    Lotto() {
        makeNumbers();
    }

    private void makeNumbers() {
        List<Integer> randnums = new ArrayList<>(NUMRANGE);
        for (int i = 1; i <= NUMRANGE; i++) {
            randnums.add(i);
        }
        Collections.shuffle(randnums);
        numbers = randnums.subList(0, NUMCOUNT);
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Boolean contains(int n) {
        return numbers.contains(n);
    }
}
