package validator;

import java.util.List;

import static domain.Lotto.MIN_LOTTO_NUMBER;
import static domain.Lotto.MAX_LOTTO_NUMBER;

public class ScannerValidator {
    public static final String ILLEGAL_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 1000원 단위의 숫자를 입력해 주세요.\n";
    public static final String ILLEGAL_LOTTO_NUMBERS_MESSAGE = "[ERROR] 1~45 사이의 서로 다른 숫자를 입력해 주세요.\n";

    public static void assertValidPurchaseAmount(int purchaseAmount) throws NumberFormatException  {
        if ((purchaseAmount % 1000) != 0) {
            throw new NumberFormatException(ILLEGAL_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public static void assertValidLottoNumbers(List<Integer> lottoNumbers) throws IllegalArgumentException{
        if (lottoNumbers.stream().distinct().count()!= lottoNumbers.size()
        || lottoNumbers.stream().anyMatch(e -> !(e >= MIN_LOTTO_NUMBER && e <= MAX_LOTTO_NUMBER)))
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBERS_MESSAGE);
    }
}
