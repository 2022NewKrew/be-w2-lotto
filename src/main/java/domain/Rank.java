package domain;

public enum Rank {
    EIGHTH(0, 0, "0개 일치"),
    SEVENTH(1, 0, "1개 일치"),
    SIXTH(2, 0, "2개 일치"),
    FIFTH(3, 5000, "3개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    THIRD(5, 1500000, "5개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 200000000, "6개 일치"),
    ;
    private final int correctCount;
    private final int winnings;
    private final String message;
    private int rankCount = 0;

    Rank(int correctCount, int winnings, String message) {
        this.correctCount = correctCount;
        this.winnings = winnings;
        this.message = message;
    }

    public static Rank valueOf(int correctCount, boolean bounsCorrect) {
        Rank[] ranks = values();
        if (correctCount == SECOND.correctCount) {
            return bounsCorrect ? SECOND : THIRD;
        }
        for (Rank rank : ranks) {
            if (correctCount == rank.correctCount) {
                return rank;
            }
        }
        return null;
    }

    public static void addRankCount(int correctCount, boolean bonusCorrect) {
        valueOf(correctCount, bonusCorrect).rankCount++;
    }

    public static int getIncome() {
        Rank[] ranks = values();
        int result = 0;
        for (Rank rank : ranks) {
            result += rank.winnings * rank.rankCount;
        }
        return result;
    }

    public static void showAllRank(){
        Rank[] ranks = values();
        for(Rank rank : ranks){
            if(rank.correctCount <= 2) continue;
            System.out.println(rank);
        }
    }

    @Override
    public String toString() {
        return this.message + "(" + this.winnings + ") - " + rankCount + "개";
    }
}
