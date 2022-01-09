package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String NUMBER_SPLIT_REGEX = ", ";
    private final List<Integer> numbers;

    public Lotto(String lottoString){
        numbers = sortAndAdd(parseLottoNumbers(lottoString));
    }
    public Lotto(List<Integer> rawNumbers) {
        numbers = sortAndAdd(rawNumbers);
    }

    private List<Integer> sortAndAdd(List<Integer> rawNumbers) {
        Collections.sort(rawNumbers);
        List<Integer> tempNumbers = new ArrayList<>(rawNumbers);
        return Collections.unmodifiableList(tempNumbers);
    }

    public int countNumbersMatch(Lotto prize) {
        return (int) this.numbers.stream().filter(prize::contains).count();
    }
    public boolean contains(int num) {
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


    public static List<Integer> parseLottoNumbers(String winningTicketString) {
        String[] spt = winningTicketString.split(NUMBER_SPLIT_REGEX);
        return Arrays.stream(spt).map(Integer::parseInt).collect(Collectors.toList());
    }
}
