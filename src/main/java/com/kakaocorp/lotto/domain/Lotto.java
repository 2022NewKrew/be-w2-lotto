package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.enums.Grade;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private boolean isClosed = false;
    private Grade grade;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Grade getGrade() {
        return grade;
    }

    public void rank(Grade grade) {
        this.grade = grade;
        this.isClosed = true;
    }
}
