package com.kakaocorp.lotto.controller;

import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.domain.WinningLotto;
import com.kakaocorp.lotto.dto.ResultResponse;
import com.kakaocorp.lotto.service.LottoService;

import java.util.List;

public class LottoGameConsoleController {

    private final IoController ioController = new IoController();
    private final LottoService lottoService = new LottoService();

    public LottoGameConsoleController() {
    }

    public List<Lotto> purchase() {
        int orderPrice = ioController.inputInt("구입금액을 입력해 주세요.");
        return lottoService.buy(orderPrice);
    }

    public ResultResponse result(List<Lotto> lottoList) {
        List<Integer> winningNumbers = ioController.inputNumbers("지난 주 당첨 번호를 입력해 주세요.");
        return lottoService.result(new WinningLotto(winningNumbers), lottoList);
    }
}
