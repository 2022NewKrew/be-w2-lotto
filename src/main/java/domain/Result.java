package domain;

public class Result {
    private final Rank rank;
    private final int count;

    public Result(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String resultString = "" + rank.getCountOfMatch() + "개 일치";
        if (rank == Rank.SECOND) {
            resultString += ",보너스 볼 일치";
        }
        resultString += "(" + rank.getWinningMoney() + "원) - " + count + "개";
        return resultString;
    }
}
