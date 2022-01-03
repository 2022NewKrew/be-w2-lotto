package parameters;

public class Result {
    private final int reward;
    private int count;

    public Result(int reward){
        this.reward = reward;
    }

    public void addCount() { count++; }
    public int getCount() { return count; }
    public int getReward() { return reward; }
    public long getEarned() { return (long) (reward * count); }
}
