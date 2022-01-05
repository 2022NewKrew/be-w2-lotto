package DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NNumber {
    private final List<Integer> numbers;

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_PER_LINE = 6;

    private NNumber() {
        List<Integer> fullNumbers = IntStream.range(MIN_NUM, MAX_NUM + 1).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(fullNumbers);


        numbers = fullNumbers.subList(0, NUM_PER_LINE);
        Collections.sort(numbers);
    }

    private NNumber(List<Integer> manualInput) {
        numbers = manualInput;
    }

    //TODO generator를 따로 빼서 도메인으로 만들고 LottoLineTest 인터페이스로 관리 할 수 있을 것으로 보인다.
    public static NNumber makeRandomNumbers() {
        return new NNumber();
    }

    public static NNumber makeManualNumbers(List<Integer> manualInput) {
        return new NNumber(manualInput);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public String getPrintLine() {
        return numbers.toString();
    }
}
