package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.ConstantValue.*;

/**
 * 로또 번호들로 이루어진 한 줄을 의미하는 클래스
 */
public class LottoNumber {
    private static final List<Integer> allNumbers =
            IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toList());
    private List<Integer> numbers;


    /**
     * parameter 없이 생성 시: 자동 생성
     * parameter 받아 생성 시: 수동 생성
     */
    public LottoNumber(){
        generateNumbers();
    }

    public LottoNumber(List<Integer> manualNumbers){
        numbers = manualNumbers;
    }

    /**
     * 1~45까지의 숫자를 섞어 앞에서부터 6자리를 받아와 로또 한 줄을 생성하는 메소드
     */
    private void generateNumbers(){
        Collections.shuffle(allNumbers);
        numbers =  new ArrayList<>(allNumbers.subList(0, SIZE_OF_LOTTO));
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {return numbers;}
}
