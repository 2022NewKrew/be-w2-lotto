package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class TicketNumbers {

    private final static String DUPLICATED_NUMBER_ERROR = "중복된 숫자가 있습니다.";
    private final static String NUMBERS_COUNT_ERROR = "숫자의 개수가 6개가 아닙니다.";
    private final static int TICKET_NUMBER_SIZE = 6;

    private final List<TicketNumber> ticketNumbers = new ArrayList<>();

    public TicketNumbers(List<Integer> numbers) {
        initiateTicketNumbers(numbers);
    }

    private void initiateTicketNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            insertTicketNumber(number);
        }
        if (ticketNumbers.size() != TICKET_NUMBER_SIZE)
            throw new IllegalArgumentException(NUMBERS_COUNT_ERROR);
    }

    private void insertTicketNumber(int number) {
        ticketNumbers.add(checkDuplicatedNumber(number));
    }

    public TicketNumber checkDuplicatedNumber(int number) {
        TicketNumber ticketNumber = new TicketNumber(number);
        if (ticketNumbers.contains(ticketNumber))
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        return ticketNumber;
    }

    public Rank compareTicket(TicketNumbers winTicket, TicketNumber bonusNumber) {
        int matchCount = 0;
        for (TicketNumber winNumber : winTicket.ticketNumbers) {
            matchCount = checkMatchCount(matchCount, winNumber);
        }

        return Rank.valueOf(matchCount, ticketNumbers.contains(bonusNumber));
    }

    private int checkMatchCount(int matchCount, TicketNumber winNumber) {
        if (ticketNumbers.contains(winNumber))
            matchCount++;
        return matchCount;
    }

    // UI 전용
    public List<TicketNumber> getTicketNumbers() {
        return ticketNumbers;
    }
}
