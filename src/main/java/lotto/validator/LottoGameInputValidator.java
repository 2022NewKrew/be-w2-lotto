package lotto.validator;

public class LottoGameInputValidator {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public int purchasePriceValidate(int purchasePrice, int ticketPrice) {
        int remainingAmount = purchasePrice % ticketPrice;
        if (remainingAmount > 0) {
            System.err.println(
                "로또 한 장 당 1000원 입니다. 남은 금액 " + remainingAmount + "원은 지갑에 다시 넣어드리겠습니다.");
            return purchasePrice - remainingAmount;
        }
        return purchasePrice;
    }
}
