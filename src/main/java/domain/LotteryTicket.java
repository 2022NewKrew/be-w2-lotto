package domain;

import domain.util.LotteryNumbersValidator;
import dto.LotteryTicketDTO;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {
    private static final LotteryNumbersFactory LOTTERY_NUMBERS_FACTORY = new LotteryNumbersFactory();
    private final List<Integer> numbers;

    public LotteryTicket(List<Integer> numbers) {
        LotteryNumbersValidator.validate(numbers);

        // For numbers are meant to be private
        this.numbers = new ArrayList<>(numbers);
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
