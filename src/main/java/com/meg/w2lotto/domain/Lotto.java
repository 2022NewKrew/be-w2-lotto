package com.meg.w2lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int SIZE = 6;
    public static final int NUMMIN = 1;
    public static final int NUMMAX = 45;
    public static final int COST = 1000;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Boolean contains(int n) {
        return numbers.contains(n);
    }
}
