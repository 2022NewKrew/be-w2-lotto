package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
** 복권 관련 상수 저장, 복권 번호 생성 기능 수행
 */
public class Lotto {

    private static final int TICKET_PRICE = 1000;
    private static final int NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private List<Integer> numberList;

    public Lotto() {
        //1 ~ 45의 자연수를 갖는 리스트 생성
        numberList = IntStream
                .rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<LottoTicket> generateAllLottoTicket(int money) {
        List<LottoTicket> tickets = new ArrayList<>();

        int ticketCount = money / TICKET_PRICE;
        while (ticketCount > 0) {
            tickets.add(generateLottoTicket());
            ticketCount--;
        }

        return tickets;
    }

    private LottoTicket generateLottoTicket() {
        Collections.shuffle(numberList, new Random());
        return new LottoTicket(numberList.subList(0, 6));
    }

    public int getTicketPrice() {
        return TICKET_PRICE;
    }

    public int getNumberCount() {
        return NUMBER_COUNT;
    }

    public int getMinNumber() {
        return MIN_NUMBER;
    }

    public int getMaxNumber() {
        return MAX_NUMBER;
    }
}
