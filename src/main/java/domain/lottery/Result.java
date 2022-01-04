package domain.lottery;

import domain.Prize;

import java.util.List;

public class Result {
    private final List<Integer> numbers;
    private final int bonusBall;

    public Result(List<Integer> numbers, int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼 " + bonusBall + "은 당첨 번호 " + numbers + "에 포함되면 안 됩니다.");
        }

        // bonusBall의 값 범위 검증 추가해야 됨
        this.numbers = numbers;
        this.bonusBall = bonusBall;
    }

    public Prize getTicketPrize(Ticket ticket) {
        return Prize.getPrize(this, ticket);
    }

    public int getMatchingCountOf(Ticket ticket) {
        return (int) numbers.stream().filter(number -> ticket.contains(number)).count();
    }

    public boolean isBonusBallMatched(Ticket ticket) {
        return ticket.contains(this.bonusBall);
    }
}
