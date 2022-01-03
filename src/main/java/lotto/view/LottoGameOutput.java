package lotto.view;

public class LottoGameOutput {

    private static final int LOTTO_PRICE = 1000;

    public static void printLottoNumbers(int purchaseAmount) {
        System.out.println(purchaseAmount/LOTTO_PRICE + "개를 구매했습니다.");
    }
}
