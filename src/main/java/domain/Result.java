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

}
