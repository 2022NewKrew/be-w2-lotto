package com.yapark97.lottoapplication;

import com.yapark97.lottoapplication.service.LottoService;

public class LottoApplication {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.run();
    }
}
