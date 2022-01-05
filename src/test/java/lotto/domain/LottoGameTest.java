package lotto.domain;

import lotto.view.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class LottoGameTest {

    @Mock
    private View view;

    @InjectMocks
    private LottoGame lottoGame;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("로또 게임 실행 테스트 - readPurchaseAmountForLotto verify 진행")
    @Test
    void run_mannualLottoNumberTextsAndWinningNumbers_verifyReadPurchaseAmountForLotto() {
        // Given
        Mockito.when(view.readPurchaseAmountForLotto()).thenReturn(2000);
        Mockito.when(view.readManualPurchaseCountForLotto()).thenReturn(1);

        List<String> manualLottoNumberTexts = new ArrayList<>();
        manualLottoNumberTexts.add("1, 2, 3, 4, 5, 6");

        LottoTicket lottoTicket = new LottoTicket(2000, manualLottoNumberTexts);
        Mockito.doNothing().when(view).printLottoCount(lottoTicket.getManualLottoCount(), lottoTicket.getAutomaticLottoCount());
        Mockito.doNothing().when(view).printLotto(lottoTicket.getLottoList());

        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        int bonusBallNumber = 7;

        LottoWinningResult lottoWinningResult = lottoTicket.getLottoWinningResult(winningNumbers, bonusBallNumber);
        Mockito.doNothing().when(view).printLottoWinningResult(lottoWinningResult);
        Mockito.doNothing().when(view).printYield(lottoTicket.getWholeLottoPrice());

        // When
        lottoGame.run();

        // Then
        Mockito.verify(view).readPurchaseAmountForLotto();

    }

}
