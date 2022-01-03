package lottery.web.dto;

public class BudgetDto {
    private int amount;

    public BudgetDto(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
