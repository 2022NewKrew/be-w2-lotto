package bin.jaden.be_w2_lotto.LottoGame;

import java.util.Collections;
import java.util.List;

public class LottoGame {
    private List<Integer> numbers;

    protected LottoGame() {
        // 자식 클래들에서 호출하는 생성자
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    protected void setNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}
