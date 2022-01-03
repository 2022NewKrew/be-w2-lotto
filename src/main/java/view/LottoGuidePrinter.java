package view;

public class LottoGuidePrinter {
    public static final String PURCHASE_AMOUNT_REQUEST = "구입 금액을 입력해 주세요.";

    public static void requestPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_REQUEST);
    }

    public static void alertPurchaseQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }
}
