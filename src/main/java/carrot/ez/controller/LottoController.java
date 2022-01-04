package carrot.ez.controller;

import carrot.ez.dto.LotteryStatisticsDto;
import carrot.ez.dto.WinningNumberDto;
import carrot.ez.lotto.Lotteries;
import carrot.ez.service.LottoService;

public class LottoController {

    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public Lotteries purchaseLotteries(long amount) {
        return lottoService.purchaseLotteries(amount);
    }

    public LotteryStatisticsDto checkWiningNumbers(Lotteries lotteries, WinningNumberDto winningNumberDto) {
        return lottoService.checkWiningNumbers(lotteries, winningNumberDto);
    }


}
