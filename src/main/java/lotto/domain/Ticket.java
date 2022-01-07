package lotto.domain;

import java.util.*;

import static lotto.domain.LotteryConstants.lotteryNumbers;


public class Ticket {
    private List<Integer> ticketNumbers;

    public Ticket() {
        createTicket();
    }

    public Ticket(List<Integer> ticketNumbers) {
        Collections.sort(ticketNumbers);
        checkNumberValidity(ticketNumbers);
        this.ticketNumbers = ticketNumbers;
    }


    void checkSingleNumberBound(int winningNumber) throws IllegalArgumentException {
        if (winningNumber<LotteryConstants.minNumber || winningNumber > LotteryConstants.maxNumber)
            throw new IllegalArgumentException("입력 숫자가 "+ LotteryConstants.minNumber + "이상 "+ LotteryConstants.maxNumber + "이하여야 합니다.");
    }

    private void checkNumberBounds(List<Integer> ticketNumbers) {
        checkSingleNumberBound(ticketNumbers.get(0));
        checkSingleNumberBound(ticketNumbers.get(ticketNumbers.size()-1));
    }

    private void checkNumberOverlap(List<Integer> ticketNumbers) throws IllegalArgumentException {
        Set<Integer> ticketNumberSet = new HashSet<>(ticketNumbers);
        if (ticketNumberSet.size()<ticketNumbers.size())
            throw new IllegalArgumentException("로또 입력 숫자가 중복됐습니다.");
    }

    private void checkNumNumbers(List<Integer> ticketNumbers) throws IllegalArgumentException {
        if (ticketNumbers.size() != LotteryConstants.ticketLength)
            throw new IllegalArgumentException("입력한 복권 숫자 개수가 " + LotteryConstants.ticketLength + "개가 아닙니다.");
    }

    private void checkNumberValidity(List<Integer> ticketNumbers) {
        checkNumNumbers(ticketNumbers);
        checkNumberBounds(ticketNumbers);
        checkNumberOverlap(ticketNumbers);
    }

    private void createTicket() {
        Collections.shuffle(lotteryNumbers);
        ticketNumbers = new ArrayList<>(lotteryNumbers.subList(0, LotteryConstants.ticketLength));
        Collections.sort(ticketNumbers);
    }

    public List<Integer> getTicketNumbers() {
        return this.ticketNumbers;
    }

}
