package be.w2.lotto.Domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ManualTicketGenerator implements TicketGenerator {

    private Queue<List<Integer>> inputList;

    public ManualTicketGenerator(List<List<Integer>> inputList, Amount amount) {
        this.inputList = new LinkedList<>();
        if (inputList == null) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다!");
        }
        if (amount.isValidLength(inputList) == false) {
            throw new IllegalArgumentException("입력 값의 크기가 올바르지 않습니다!");
        }
        for (List<Integer> input : inputList)
            this.inputList.add(input);
    }

    @Override
    public LottoTicket generate() {
        return LottoTicket.getInstanceByIntList(inputList.poll());
    }

}
