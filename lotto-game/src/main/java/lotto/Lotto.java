package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    static  List<Integer> baseNumber = null;
    private List<Integer> numbers;

    public Lotto(String initialNumbers) {
        numbers = new ArrayList<>();
        for(String number : initialNumbers.split(", ")){
            numbers.add(Integer.parseInt(number));
        }
        Collections.sort(numbers);
    }

    public Lotto() {
        if(baseNumber == null) initialize();

        numbers = new ArrayList<>();
        Collections.shuffle(baseNumber);
        for(int index = 0; index < 6; index++){
            numbers.add(baseNumber.get(index));
        }
        Collections.sort(numbers);
    }

    public void print() {
        System.out.printf("[ ");
        for(int index = 0; index < 6; index++){
            System.out.printf(numbers.get(index) +"");
            if(index < 5) System.out.printf(", ");
        }
        System.out.printf("]\n");
    }

    public int compare(Lotto lotto) {
        int result = 0;
        for(int number : numbers){
            result += lotto.contain(number);
        }
        return result;
    }

    private int contain(int number) {
        if(numbers.contains(number)) return 1;
        return 0;
    }

    private void initialize(){
        baseNumber = new ArrayList<>();
        for(int number = 1; number <= 45; number++){
            baseNumber.add(number);
        }
    }
}
