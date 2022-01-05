package lotto.domain.game;

import java.util.InputMismatchException;

public class LottoPurchasePrice {

    private static final String PURCHASE_PRICE_ERROR_MESSAGE = "로또 한 장의 가격은 1000원 입니다. "
        + "1000원의 배수로 금액을 입력해 주세요.";
    private static final String NOT_ENOUGH_PRICE_ERROR_MESSAGE = "입력한 금액 내에서만 구매가 가능합니다.";

    private static final double RATE_BASE = 100.0;

    private static final int LOTTO_TICKET_PRICE = 1_000;

    private int purchasePrice;

    public static LottoPurchasePrice from(int purchasePrice) {
        return new LottoPurchasePrice(purchasePrice);
    }

    private LottoPurchasePrice(int purchasePrice) {
        if (!isValidPrice(purchasePrice)) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ERROR_MESSAGE);
        }
        this.purchasePrice = purchasePrice;
    }

    private boolean isValidPrice(int price) {
        return price % LOTTO_TICKET_PRICE == 0;
    }

    public double calculateProfitRate(int totalPrizeMoney) {
        return ((double) totalPrizeMoney - purchasePrice) / (double) purchasePrice * RATE_BASE;
    }

    public int availableNumberOfTickets() {
        return purchasePrice / LOTTO_TICKET_PRICE;
    }

    public void purchaseAmountOrElseThrow(int purchaseAmount) {
        if (purchaseAmount > availableNumberOfTickets()) {
            throw new InputMismatchException(NOT_ENOUGH_PRICE_ERROR_MESSAGE);
        }
        purchasePrice -= purchaseAmount * LOTTO_TICKET_PRICE;
    }
}
