package carrot.ez.lotto;

import java.util.List;

public class Lottery {
    public static final int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNumber(int idx) {
        if (numbers.size() <= idx) {
            throw new IndexOutOfBoundsException("index 범위를 초과하였습니다.");
        }
        return numbers.get(idx);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getNumOfCorrect(List<Integer> winNums) {
        int numOfCorrect = 0;
        for (Integer num : winNums) {
            numOfCorrect += contains(num) ? 1 : 0;
        }
        return numOfCorrect;
    }
    public boolean isCorrectBonus(int bonus) {
        return contains(bonus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }
}
