package Domain.Tickets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ticket {
    protected static final int NUM_OF_LOTTO_NUMBERS = 6;
    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;
    protected static final List<Integer> LOTTO_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
    protected List<Integer> selectedNumbers = new ArrayList<>();

    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers;
    }

    public static int getLength() {
        return NUM_OF_LOTTO_NUMBERS;
    }

    public static int getMinNumber() {
        return MIN_NUMBER;
    }

    public static int getMaxNumber() {
        return MAX_NUMBER;
    }
}
