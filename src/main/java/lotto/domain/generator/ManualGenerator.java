package lotto.domain.generator;

import lotto.domain.Ticket;

import java.util.List;

public class ManualGenerator implements Generator {

    private final List<Integer> numberList;

    public ManualGenerator(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @Override
    public Ticket generate() {
        return new Ticket(numberList);
    }
}
