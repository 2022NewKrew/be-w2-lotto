package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
** 실제 개별 복권 한 줄에 해당하는 클래스
 */
public class Lottery {

    private List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int countMatchedNumber(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            count += numbers.get(i).equals(winningNumbers.get(i)) ? 1 : 0;
        }
        return count;
    }

    public String numbersToString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("[%d", numbers.get(0)));
        for (int i = 1; i < numbers.size(); i++) {
            sb.append(String.format(", %d", numbers.get(i)));
        }
        sb.append("]");

        return sb.toString();
    }
}
