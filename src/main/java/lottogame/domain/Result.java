package lottogame.domain;

public class Result {
    private int countOfSameNumber;
    private int prizeMoney;
    private int countOfTickets;

    Result(int countOfSameNumber, int prizeMoney, int countOfTickets) {
        this.countOfSameNumber = countOfSameNumber;
        this.prizeMoney = prizeMoney;
        this.countOfTickets = countOfTickets;
    }

    public int getCountOfSameNumber() {
        return countOfSameNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCountOfTickets() {
        return countOfTickets;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)- %d개", countOfSameNumber, prizeMoney, countOfTickets);
    }
}
