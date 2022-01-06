package domain;

public class Purchase {
    public static final int PRICE = 1000;
    private final int amount;

    public Purchase(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalPurchaseQuantity() {
        return amount / PRICE;
    }
}
