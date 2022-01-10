package controller;

import controller.dto.LottoListDTO;
import controller.dto.LottoResultDTO;
import controller.dto.PurchaseDTO;
import controller.dto.SimulateDTO;
import domain.lottery.WinningLotto;
import domain.lotto.LottoList;
import domain.statistics.Statistics;
import domain.statistics.YieldStatistics;
import utils.Convertor;

public class LottoController {

  private final LottoService lottoService;

  public LottoController(LottoService lottoService) {
    this.lottoService = lottoService;
  }


  // /lotto/purchase
  public LottoListDTO buyLotto(PurchaseDTO purchaseDto) {
    int purchaseAmount = purchaseDto.getAmount();
    LottoList manualBuyList = Convertor.dtoToDomain(purchaseDto.getLottoList());
    LottoList buyList = lottoService.buyLotto(purchaseAmount, manualBuyList);
    return Convertor.domainToDto(buyList);
  }


  // /lotto/simulate
  public LottoResultDTO simulateLottery(SimulateDTO simulateDTO) {
    WinningLotto winningLotto = Convertor.dtoToDomain(simulateDTO.getWinningLotto(), simulateDTO.getBonusNumber());
    LottoList wallet = Convertor.dtoToDomain(simulateDTO.getWallet());
    YieldStatistics statistics = lottoService.simulateLottery(winningLotto, wallet);




    return null;
  }

}
