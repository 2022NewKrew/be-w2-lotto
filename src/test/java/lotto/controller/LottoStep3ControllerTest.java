package lotto.controller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class LottoStep3ControllerTest {

    private LottoStep3Controller step3Controller;

    @Test
    void startTest(){
        final String inputStr = "5000\n2\n1,2,3,4,5,6\n1,2,3,5,6,7\n1,2,3,4,5,6\n7";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);

        step3Controller = new LottoStep3Controller();
        step3Controller.start();
    }
}