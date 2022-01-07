package input;

import step3.input.CommandLineInputView;
import step3.lotto.domain.WinningLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommandLineInputViewTest {
    @Test
    @DisplayName("천원 단위의 입력을 받지 않았을때")
    void ticketAmountCheck() {
        // given
        CommandLineInputView commandLineInputView = new CommandLineInputView();
        String str = "14456";


        // when
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(byteArrayInputStream);
        int amount = commandLineInputView.inputBuyTicketAmount();

        // then
        assertEquals(14, amount);
    }
}