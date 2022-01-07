package domain;

import spark.Request;
import util.InputChecker;
import view.LottoView;
import view.LottoWebView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 복권 관련 상수 저장, 복권 번호 생성 기능 수행
 */
public class Lotto {

    private static final int TICKET_PRICE = 1000;
    private static final int NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numberList;

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

        tickets.addAll(createManualTicketList(view, checker, manualTicketCount));
        tickets.addAll(createAutoTicketList(checker, money, manualTicketCount));

        return tickets;
    }

    public List<LottoTicket> generateAllLottoTicket(LottoWebView view,
                                                    InputChecker checker,
                                                    int money,
                                                    List<String> manualTicketNumberStringList) {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.addAll(createManualTicketList(view, checker, manualTicketNumberStringList));
        tickets.addAll(createAutoTicketList(checker, money, manualTicketNumberStringList.size()));

        return tickets;
    }

    private List<LottoTicket> createManualTicketList(LottoWebView view,
                                                     InputChecker checker,
                                                     List<String> manualTicketNumberStringList) {
        return manualTicketNumberStringList.stream()
                .map(str -> generateManualLottoTicket(view, checker, str))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> createManualTicketList(LottoView view,
                                                     InputChecker checker,
                                                     int manualTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, manualTicketCount)
                .mapToObj(i -> generateManualLottoTicket(view, checker))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> createAutoTicketList(InputChecker checker,
                                                   int money,
                                                   int manualTicketCount) {
        List<LottoTicket> autoTicketList = new ArrayList<>();
        int ticketCount = money / TICKET_PRICE - manualTicketCount;
        IntStream.range(0, ticketCount)
                .forEach(i -> autoTicketList.add(generateAutoLottoTicket(checker)));

        return autoTicketList;
    }

    private LottoTicket generateManualLottoTicket(LottoView view,
                                                  InputChecker checker) {
        List<Integer> manualNumber = view.inputIntegerList("");
        return new LottoTicket(this, checker, manualNumber);
    }

    private LottoTicket generateManualLottoTicket(LottoWebView view,
                                                  InputChecker checker,
                                                  String line) {
        List<Integer> manualNumber = view.inputIntegerList(line);
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
