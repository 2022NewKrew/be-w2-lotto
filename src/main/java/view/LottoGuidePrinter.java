package view;

import domain.Lotto;
import domain.MatchScore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGuidePrinter {
    private static final String COMMA = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";
    private static final String PURCHASE_AMOUNT_REQUEST = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.\n";
    private static final String WINNING_LOTTO_REQUEST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---------";
    private static final String MATCH_COUNT = "%d개 일치 (%d원) - %d개\n";
    private static final String TOTAL_RETURN = "총 수익률: %.0f%%입니다.";

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
        System.out.println();
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getBalls().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA, OPEN_BRACKET, CLOSING_BRACKET))
        );
    }

    public static void requestLottoNumberInput() {
        System.out.println(WINNING_LOTTO_REQUEST);
    }

    public static void printLottoResult(int purchaseAmount, MatchScore matchScore) {
        System.out.println(WINNING_STATISTICS);
        for (Map.Entry<Integer, Integer> e : matchScore.getCount().entrySet()) {
            System.out.printf(MATCH_COUNT, e.getKey(), MatchScore.PRICES.get(e.getKey()), e.getValue());
        }
        System.out.printf(TOTAL_RETURN, (matchScore.getTotalPrice() / ((double)purchaseAmount)) * 100);
    }
}
