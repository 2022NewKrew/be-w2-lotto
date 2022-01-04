package lottery.web.dto;

import java.util.ArrayList;
import java.util.List;

public class LotteryDto {

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    private ArrayList<Integer> numbers;

    public LotteryDto(List<Integer> numbers) {
        this.numbers = new ArrayList<Integer>(numbers);
    }
}
