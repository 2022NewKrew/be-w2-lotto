package controller;

import VO.StatsVO;
import domain.Lotto;
import service.CalculateStatsService;
import service.MakeWinningLottoService;

import java.util.List;

public class StatsController {
    private final static MakeWinningLottoService makeWinningLottoService = new MakeWinningLottoService();
    private final static CalculateStatsService calculateStatsService = new CalculateStatsService();

    public StatsVO calculateStats(List<Lotto> lottoList, String winningLottoString, int bonusNumber) {
        Lotto winningLotto = makeWinningLottoService.getWinningLotto(winningLottoString, bonusNumber);
        return calculateStatsService.calculateStats(lottoList, winningLotto);
    }
}
