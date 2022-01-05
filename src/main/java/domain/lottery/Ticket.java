package domain.lottery;

import dto.TicketDTO;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;
    private static final NumbersFactory numbersFactory = new NumbersFactory();

    public Ticket(List<Integer> numbers) {
        this.numbers = numbersFactory.getValidatedNumbers(numbers);
    }

    public Ticket() {
        this.numbers = numbersFactory.getRandomNumbers();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public TicketDTO toDTO() {
        return new TicketDTO(numbers);
    }
}
