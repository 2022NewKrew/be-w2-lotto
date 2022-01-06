package com.kakaocorp.lotto.controller;

import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.domain.WinningLotto;
import com.kakaocorp.lotto.dto.BuyLottoDto;
import com.kakaocorp.lotto.dto.ResultResponse;
import com.kakaocorp.lotto.service.LottoService;

import java.util.List;

public class LottoGameConsoleController {

    private final IoController ioController = new IoController();
    private final LottoService lottoService = new LottoService();

    public LottoGameConsoleController() {
    }

    public BuyLottoDto buy() throws Exception {
        int orderPrice = 0;
        int orderManualNumber = 0;

        try {
            orderPrice = ioController.inputInt("구입금액을 입력해 주세요.");
            orderManualNumber = ioController.inputInt("수동으로 구매할 로또 수를 입력해 주세요.");
        } catch (NumberFormatException e) {
            System.out.println("[NumberFormatException] - 숫자를 입력해주세요.");
            throw new Exception("Exception 메세지를 참고하여 다시 진행해주세요!");
        }

        List<Lotto> lottoList = ioController.inputManualNumbers("수동으로 구매할 번호를 입력해 주세요.", orderManualNumber);
        return lottoService.buy(orderPrice, lottoList);
    }

    public ResultResponse result(List<Lotto> lottoList) throws Exception {
        List<Integer> winningNumbers;

        int bonusBall;
        try {
            winningNumbers = ioController.inputNumbers("지난 주 당첨 번호를 입력해 주세요.");
            bonusBall = ioController.inputInt("보너스 볼을 입력해 주세요.");
        } catch (NumberFormatException e) {
            System.out.println("[NumberFormatException] - 숫자를 입력해주세요.");
            throw new Exception("Exception 메세지를 참고하여 다시 진행해주세요!");
        }

        return lottoService.result(new WinningLotto(winningNumbers, bonusBall), lottoList);
    }
}
