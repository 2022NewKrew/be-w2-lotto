package lotto;


final class LotteryConstants {
    static final int maxNumber = 45;
    static final int ticketLength = 6;

    enum prizeMoney {
        FIFTH(5000, 5), FOURTH(50000, 4), THIRD(1500000, 3), SECOND(30000000, 2), FIRST(2000000000, 1);

        private final int prize, rank;
        prizeMoney(int prize, int rank) {
            this.prize = prize;
            this.rank = rank;
        }

        public int getMoney() {return prize;}
        public int getRank() {return rank;}
    }
}
