package step1.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoViewTest {
    @DisplayName("잘못된 금액을 입력했을 때 오류 확인")
    @Test
    public void resultWrongInputTestWithOnlyBlanks() {
        String input = "1500\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertThrows(NumberFormatException.class, LottoView::askMoneyForBuyLotto);
    }
}