package view;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGuidePrinter {
    private static final String PURCHASE_AMOUNT_REQUEST = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.";

    public static void requestPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_REQUEST);
    }

    public static void alertPurchaseQuantity(int quantity) {
        System.out.println(quantity + PURCHASE_QUANTITY);
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto: lottoList) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"))
        );
    }
}
