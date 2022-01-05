package domain;

import util.InputChecker;
import view.LottoView;

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

    public List<LottoTicket> generateAllLottoTicket(LottoView view,
                                                    InputChecker checker,
                                                    int money,
                                                    int manualTicketCount) {
        List<LottoTicket> tickets = new ArrayList<>();

        if (manualTicketCount > 0) {
            tickets.addAll(creatManualTicketList(view, checker, manualTicketCount));
        }
        tickets.addAll(createAutoTicketList(checker, money, manualTicketCount));

        return tickets;
    }

    private List<LottoTicket> creatManualTicketList(LottoView view,
                                                    InputChecker checker,
                                                    int manualTicketCount) {
        List<LottoTicket> manualTicketList = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        while (manualTicketCount-- > 0) {
            manualTicketList.add(generateManualLottoTicket(view, checker));
        }

        return manualTicketList;
    }

    private List<LottoTicket> createAutoTicketList(InputChecker checker,
                                                   int money,
                                                   int manualTicketCount) {
        List<LottoTicket> autoTicketList = new ArrayList<>();
        int ticketCount = money / TICKET_PRICE - manualTicketCount;

        while (ticketCount-- > 0) {
            autoTicketList.add(generateAutoLottoTicket(checker));
        }

        return autoTicketList;
    }

    private LottoTicket generateManualLottoTicket(LottoView view,
                                                  InputChecker checker) {
        List<Integer> manualNumber = view.inputIntegerList("");
        return new LottoTicket(this, checker, manualNumber);
    }

    private LottoTicket generateAutoLottoTicket(InputChecker checker) {
        Collections.shuffle(numberList, new Random());
        return new LottoTicket(this, checker, numberList.subList(0, 6));
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
