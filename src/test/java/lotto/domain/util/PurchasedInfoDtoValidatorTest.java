package lotto.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchasedInfoDtoValidatorTest {
    static final PurchasedInfoValidator purchasedInfoValidator = new PurchasedInfoValidator();

    @Test
    void 구입금액이_1000원_이하면_예외를_던진다(){
        //given
        int purchasePrice = 900;
        int countOfManualLotto = 0;

        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> purchasedInfoValidator.validatePurchasedInfoInput(purchasePrice, countOfManualLotto));
    }

    @Test
    void 구입금액보다_수동구매한_로또의_수가_많으면_예외를_던진다(){
        //given
        int purchasePrice = 3000;
        int countOfManualLotto = 4;

        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> purchasedInfoValidator.validatePurchasedInfoInput(purchasePrice, countOfManualLotto));
    }
}