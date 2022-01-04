package bin.jaden.be_w2_lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static List<Integer> allNumbers;
    private final List<Integer> numbers;
    private final int bonusNumber;

    LottoGame() {
        Collections.shuffle(allNumbers);
        List<Integer> numbers = new ArrayList<>(allNumbers.subList(0, Constants.NUMBERS_PER_GAME));
        Collections.sort(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
        bonusNumber = -1;
    }

    public LottoGame(List<Integer> numbers, int bonusNumber) {
        this.numbers = Collections.unmodifiableList(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static void initAllNumbers() {
        allNumbers = new ArrayList<>(45);
        for (int i = Constants.MIN_LOTTO_NUMBER; i <= Constants.MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(i);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}
