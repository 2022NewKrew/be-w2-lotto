package domain;

public class Result {
    private final Rank rank;
    private final int count;

    public Result(Rank rank, int count) {
        this.rank = rank;
        this.count = count;

        validateCount(count);
    }

    private void validateCount(int count) {
        if (count < 0) throw new IllegalArgumentException();
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }

}
