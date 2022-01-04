package input;

import input.dto.InputInfo;
import lotto.domain.WinningLotto;
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

    @Test
    @DisplayName("입력 받은 내용이 int List로 잘 변환되는가")
    void targetInputTest() {
        // given
        InputInfo inputInfo = new InputInfo(5);
        CommandLineInputView commandLineInputView = new CommandLineInputView();
        String str = "1, 3, 4, 5, 6";

        // when
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(byteArrayInputStream);
        List<Integer> integers = commandLineInputView.inputLottoNum();
        WinningLotto winningLotto = new WinningLotto(integers, 7);

        // then
        assertEquals(true, winningLotto.getNumbers() instanceof List);
    }

}