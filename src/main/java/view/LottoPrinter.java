package view;

import dto.YieldDto;
import dto.LottoResultDto;
import dto.LottoResultsDto;

import java.util.List;

public class LottoPrinter {


    public void printLotto(List<String> lottoTicketsView) {
        lottoTicketsView.forEach(System.out::println);
    }

    public void printLottoResults(LottoResultsDto lottoResultDtos) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottoResultDtos.getLottoResultDtos().forEach(this::printLottoResult);
    }

    private void printLottoResult(LottoResultDto lottoResult) {
        if (lottoResult.getLottoResult().isNeedMatchedBonusNumber()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", lottoResult.getLottoResult().getNumberOfMatchedNumber()
                    , lottoResult.getLottoResult().getPrizeMoney(), lottoResult.getCount());
            return;
        }
        System.out.printf("%d개 일치 (%d원)- %d개\n", lottoResult.getLottoResult().getNumberOfMatchedNumber()
                , lottoResult.getLottoResult().getPrizeMoney(), lottoResult.getCount());
    }

    public void printYield(YieldDto lottoDto) {
        System.out.println("총 수익률은 " + (lottoDto.getEarnedMoney() - lottoDto.getPrice()) / lottoDto.getPrice() * 100 + "%입니다.");
    }
}
