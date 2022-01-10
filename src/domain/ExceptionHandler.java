package domain;

import domain.tickets.Ticket;
import domain.tickets.Tickets;
import exceptions.LackOfMoneyException;
import exceptions.ListSizeException;
import exceptions.NumberRangeException;
import exceptions.DuplicatedNumberException;
import view.View;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 입력받은 값에 대해 조건에 부합하는지 검증하고, 예외가 발생한다면 Exception을 catch하여 처리하는 로직
// 이중 indent를 지양하라는 요구사항 때문에 어쩔수없이 재귀로 view input을 받는 의존성을 가짐
// 또한 지금 현재로서는 GroundRule이 하나밖에 없기 때문에, 이에 의존하는 모양이지만 향후 여러가지 Rule이 생긴다면 Rule을 받아 이에 따라 처리하면 될 것
public class ExceptionHandler {
    private View view = new View();

    // 검증된 입력 스트링으로부터 얻은 정수
    public int integerFromVerifiedString(String string) {
        try {
            return DataFormatting.stringToInteger(string);
        } catch (NumberFormatException e) {
            view.print("정수가 아닌 입력입니다. 정수를 입력하세요.");
            return integerFromVerifiedString(view.inputString());
        }
    }

    // 수동티켓 구매가 가능한지 검증 후 그대로 리턴
    public int verifiedNumofTickets(int ticketPrice, int numOfTickets, int buyerpaid) {
        try {
            verifyPossibleBuying(ticketPrice, numOfTickets, buyerpaid);
            return numOfTickets;
        } catch (LackOfMoneyException e) {
            view.print("구매금액이 부족합니다. 티켓 개수를 다시 입력해주세요.");
            return verifiedNumofTickets(ticketPrice, integerFromVerifiedString(view.inputString()), buyerpaid);
        }
    }

    // 티켓 구매 가능 검증
    public void verifyPossibleBuying(int ticketPrice, int numOfTickets, int buyerPaid) throws LackOfMoneyException {
        if (ticketPrice * numOfTickets > buyerPaid) {
            throw new LackOfMoneyException();
        }
    }

    public List<Integer> verifiedTicketNumbers(String string) {
        try {
            List<String> stringList = DataFormatting.parseString(string);
            verifyListSize(stringList, GroundRule.NUM_OF_SELECTION);
            List<Integer> integerList = DataFormatting.stringListToIntegerList(stringList);
            verifyTicketNumbers(integerList);
            return integerList;

        } catch (ListSizeException | NumberRangeException | DuplicatedNumberException e) {
            view.print("입력하신 번호의 형식이 틀렸습니다. 다시 입력하세요.");
            return verifiedTicketNumbers(view.inputString());
        }
    }

    public void verifyListSize(List<String> stringList, int size) throws ListSizeException {
        if (stringList.size() != size) {
            throw new ListSizeException();
        }
    }

    public void verifyTicketNumbers(List<Integer> integerList) throws DuplicatedNumberException, NumberRangeException {
        Set<Integer> integerSet = new HashSet<>(integerList);
        if (integerSet.size() != integerList.size()) {
            throw new DuplicatedNumberException();
        }
        for (Integer number : integerList) {
            verifyNumberRange(number, GroundRule.MIN_SELECTION_NUMBER, GroundRule.MAX_SELECTION_NUMBER);
        }
    }

    public void verifyNumberRange(int target, int min, int max) throws NumberRangeException {
        if (target < min || target > max) {
            throw new NumberRangeException();
        }
    }

}
