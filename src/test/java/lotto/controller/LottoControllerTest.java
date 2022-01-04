package lotto.controller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    private LottoController controller; //= new LottoController();
    @Test
    void startTest(){
        final String inputStr = "50000\n1,2,3,4,5,6\n7";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);

        controller = new LottoController();
        controller.start();
    }

}