package lottery.web.dto;

import java.util.ArrayList;

public class LotteryWinningNumberDto {
    private ArrayList<Integer> numbers = new ArrayList<>();

    public LotteryWinningNumberDto(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
