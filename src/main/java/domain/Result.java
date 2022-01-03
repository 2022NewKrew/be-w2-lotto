package domain;

public class Result {
    private int reward;
    private int count = 0;

    public Result(int reward) {
        this.reward = reward;
    }

    public void increaseCount() {
        this.count++;
    }

    public int getReward() {
        return this.reward;
    }

    public int getCount() {
        return this.count;
    }
}
