package back.controller;

import back.domain.Prize;
import dto.LottoCreateDto;
import dto.LottoDto;
import dto.WinningLottoCreateDto;
import back.service.LottoService;
import back.service.WinningLottoService;

import java.util.List;

public class Controller {
    private final WinningLottoService winningLottoService;
    private final LottoService lottoService;

    public Controller(WinningLottoService winningLottoService, LottoService lottoService) {
        this.winningLottoService = winningLottoService;
        this.lottoService = lottoService;
    }

    public void createLotto(LottoCreateDto lottoCreateDto) {
        lottoService.createLotto(lottoCreateDto);
    }

    public List<LottoDto> getLottoList() {
        return lottoService.getLottoList();
    }

    public void createWinningLotto(WinningLottoCreateDto winningLottoCreateDto) {
        winningLottoService.createWinningLotto(winningLottoCreateDto);
    }

    public List<Prize> getResults() {
        return lottoService.getResults();
    }
}
