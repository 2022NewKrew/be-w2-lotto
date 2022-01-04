package carrot.ez.lotto;

import java.util.List;

public class Lottery {
    public static final int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getNumOfCorrect(List<Integer> winNums) {
        return winNums.stream()
                .reduce(0, (total, num) -> contains(num) ? total + 1 : total);
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
