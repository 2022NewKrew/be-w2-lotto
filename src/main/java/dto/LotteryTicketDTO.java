package dto;

import java.util.List;

public class LotteryTicketDTO {
    public final List<Integer> numbers;

    public LotteryTicketDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
