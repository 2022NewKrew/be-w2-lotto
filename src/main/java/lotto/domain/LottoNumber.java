package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.ConstantValue.*;


public class LottoNumber {
    private static final List<Integer> allNumbers =
            IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toList());
    private List<Integer> numbers;


    public LottoNumber(){
        generateNumbers();
    }

    public LottoNumber(List<Integer> manualNumbers){
        numbers = manualNumbers;
    }


    private void generateNumbers(){
        Collections.shuffle(allNumbers);
        numbers =  new ArrayList<>(allNumbers.subList(0, SIZE_OF_LOTTO));
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {return numbers;}
}
