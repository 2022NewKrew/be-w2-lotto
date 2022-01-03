package domain;

import java.util.List;

public class Lotto {
    private static final int PRICE = 1000;
    private static final int NUMBER = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static int getPurchaseQuantity(int amount) {
        return amount / PRICE;
    }
}
