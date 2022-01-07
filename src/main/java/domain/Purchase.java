package domain;

public class Purchase {
    public static final int ONE_LOTTO_PRICE = 1000;
    private final int amount;
    private final int autoGeneratedLottoQuantity;
    private final int manualGeneratedLottoQuantity;

    public Purchase(int amount, int autoGeneratedLottoQuantity, int manualGeneratedLottoQuantity) {
        assertValidPurchaseAmount(amount);
        assertValidPurchaseQuantity(autoGeneratedLottoQuantity, manualGeneratedLottoQuantity);
        this.amount = amount;
        this.autoGeneratedLottoQuantity = autoGeneratedLottoQuantity;
        this.manualGeneratedLottoQuantity = manualGeneratedLottoQuantity;
    }

    private void assertValidPurchaseAmount(int amount) throws IllegalArgumentException {
        if ((amount < 0) || (amount % Purchase.ONE_LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void assertValidPurchaseQuantity(int autoGeneratedLottoQuantity, int manualGeneratedLottoQuantity) throws IllegalArgumentException {
        if (autoGeneratedLottoQuantity < 0 || manualGeneratedLottoQuantity < 0) {
            throw new IllegalArgumentException();
        }
        if (ONE_LOTTO_PRICE * (autoGeneratedLottoQuantity + manualGeneratedLottoQuantity) != (amount)) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getAutoGeneratedLottoQuantity() {
        return autoGeneratedLottoQuantity;
    }

    public int getManualGeneratedLottoQuantity() {
        return manualGeneratedLottoQuantity;
    }

    public static int purchaseableQuantity(int amount) {
        if ((amount < 0) || (amount % ONE_LOTTO_PRICE != 0)) {
            return 0;
        }
        return amount / ONE_LOTTO_PRICE;
    }
}
