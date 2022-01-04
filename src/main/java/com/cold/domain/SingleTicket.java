package com.cold.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class SingleTicket {
    private List<Integer> numbers;
    private Boolean bonusMatch;

    public SingleTicket() {
        bonusMatch = false;
        List wholeNumbers = createWholeNumbers();
        Collections.shuffle(wholeNumbers);
        numbers = wholeNumbers.subList(0, 6);
        Collections.sort(numbers);
    }

    private List createWholeNumbers() {
        List<Integer> wholeNumbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            wholeNumbers.add(i + 1);
        }
        return wholeNumbers;
    }
}
