package lottery.domain.lotteries;

public class UserEntity {
    public UserEntity(int budget) {
        this.budget = budget;
    }

    private int budget;

    public int getBudget() {
        return budget;
    }
}
