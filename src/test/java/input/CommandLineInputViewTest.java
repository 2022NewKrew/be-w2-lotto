package input;

import input.dto.InputInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
        InputInfo input = commandLineInputView.getBuyInfo();

        // then
        Assertions.assertEquals(14, input.getAmountOfTicket());
    }

}