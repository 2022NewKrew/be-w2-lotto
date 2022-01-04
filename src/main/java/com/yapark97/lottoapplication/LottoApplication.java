package com.yapark97.lottoapplication;

import com.yapark97.lottoapplication.service.LottoService;
import com.yapark97.lottoapplication.view.SimpleLottoInput;
import com.yapark97.lottoapplication.view.SimpleLottoOutput;

public class LottoApplication {
    public static void main(String[] args) {
        // Standart input/output 사용한 view 클래스
        LottoService lottoService = new LottoService(SimpleLottoInput.getInstance(), SimpleLottoOutput.getInstance());
        lottoService.run();
    }
}
