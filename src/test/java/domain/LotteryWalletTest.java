package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.util.LotteryConfigs.TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.*;

class LotteryWalletTest {
    @Test
    @DisplayName("부족한 예산으로는 티켓 결제를 하지 못하여야 합니다.")
    void Given_LotteryWalletWithInsufficientBudget_When_BuyingTickets_Then_RaiseIllegalArgumentException() {
        // Given
        LotteryWallet lotteryWallet = new LotteryWallet(TICKET_PRICE * 10);
        int tooMuchTickets = 11;

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lotteryWallet.buyTickets(tooMuchTickets);
        });

        // Then
        String partialExpectedMessage = "을 지불하기에 부족합니다.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(partialExpectedMessage));
    }
}