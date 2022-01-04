package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoNumber {
    private static final List<Integer> allNumbers =
            IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toList());
    private static final int SIZE_OF_NUMBERS = 6;
    private List<Integer> numbers;


    public LottoNumber(){
        generatePaper();
    }


    private void generatePaper(){
        Collections.shuffle(allNumbers);
        numbers =  new ArrayList<>(allNumbers.subList(0, SIZE_OF_NUMBERS));
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {return numbers;}
}
