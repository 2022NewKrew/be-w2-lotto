package lottery.domain.lotteries;

import java.util.ArrayList;
import java.util.List;

public class LotteryEntity {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LotteryEntity(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String toString() {
        ArrayList<String> temp = new ArrayList<>();
        for (Integer el : numbers) {
            temp.add(el.toString());
        }
        return String.join(",", temp);
    }

}
