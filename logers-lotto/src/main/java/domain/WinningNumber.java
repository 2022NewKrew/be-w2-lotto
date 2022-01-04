package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int getMatchedNumber(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        if(lottoNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("당첨번호의 갯수와 로또번호의 갯수가 다릅니다.");
        }

        int matchedNumber = 0;
        for(int i=0; i<numbers.size(); i++){
            matchedNumber += numOfSame(numbers.get(i), lottoNumbers.get(i));
        }
        return matchedNumber;
    }

    private int numOfSame(int number1, int number2){
        if(number1 == number2){
            return 1;
        }

        return 0;
    }
}
