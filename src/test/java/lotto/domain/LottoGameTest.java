package lotto.domain;

import lotto.view.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class LottoGameTest {

    @Mock
    private View view;

    @InjectMocks
    private LottoGame lottoGame;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void run() {
        // Given

        Mockito.when(view.readPurchaseAmountForLotto()).thenReturn(14000);

        Lotto lotto = new Lotto(14000);
        Mockito.doNothing().when(view).printLottoCount(lotto.getLottoCount());
        Mockito.doNothing().when(view).printLotto(lotto.getLottoRows());

        LottoWinningResult lottoWinningResult = lotto.getLottoWinningResult();
        Mockito.doNothing().when(view).printLottoWinningResult(lottoWinningResult);
        Mockito.doNothing().when(view).printYield(lotto.getWholeLottoPrice());

        // When
        lottoGame.run();

        // Then
        Mockito.verify(view).readPurchaseAmountForLotto();

    }
}