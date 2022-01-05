package domain;

import dto.LotteryTicketDTO;

import java.util.List;

public class LotteryTicket {
    private static final LotteryNumbersFactory LOTTERY_NUMBERS_FACTORY = new LotteryNumbersFactory();
    private final List<Integer> numbers;

    public LotteryTicket(List<Integer> numbers) {
        this.numbers = LOTTERY_NUMBERS_FACTORY.getValidatedNumbers(numbers);
    }

    public LotteryTicket() {
        this.numbers = LOTTERY_NUMBERS_FACTORY.getRandomNumbers();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public LotteryTicketDTO toDTO() {
        return new LotteryTicketDTO(numbers);
    }
}
