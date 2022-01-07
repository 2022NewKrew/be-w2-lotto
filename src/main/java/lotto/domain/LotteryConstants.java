package lotto.domain;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LotteryConstants {
    public static final int minNumber = 1;
    public static final int maxNumber = 45;
    public static final int ticketLength = 6;
    public static final int bonusRank = 2;
    static final List<Integer> lotteryNumbers = IntStream.rangeClosed(minNumber, maxNumber).boxed().collect(Collectors.toList());

    public enum PrizeMoney {
        FIFTH(5000, 5, 3),
        FOURTH(50000, 4, 4),
        THIRD(1500000, 3, 5),
        SECOND(30000000, 2, 5),
        FIRST(2000000000, 1, 6);

        public final int prize, rank, matches;
        PrizeMoney(int prize, int rank, int matches) {
            this.prize = prize;
            this.rank = rank;
            this.matches = matches;
        }
    }
}
