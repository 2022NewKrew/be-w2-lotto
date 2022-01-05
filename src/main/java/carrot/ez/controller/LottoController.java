package carrot.ez.controller;

import carrot.ez.dto.LotteryStatisticsDto;
import carrot.ez.dto.WinningNumberDto;
import carrot.ez.lotto.Lotteries;
import carrot.ez.lotto.Lottery;
import carrot.ez.service.LottoService;

import java.util.List;

public class LottoController {

    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public Lotteries purchaseLotteries(long amount, List<Lottery> manualLotteries) {
        return lottoService.purchaseLotteries(amount, manualLotteries);
    }

    public LotteryStatisticsDto checkWiningNumbers(Lotteries lotteries, WinningNumberDto winningNumberDto) {
        return lottoService.checkWiningNumbers(lotteries, winningNumberDto);
    }


}
