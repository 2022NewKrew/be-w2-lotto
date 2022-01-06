package controller;

import dto.LottoListCreateDto;
import dto.LottoDto;
import dto.ResultDto;
import dto.WinningLottoCreateDto;
import service.LottoService;
import service.WinningLottoService;

import java.util.List;

public class Controller {
    private final WinningLottoService winningLottoService;
    private final LottoService lottoService;

    public Controller(WinningLottoService winningLottoService, LottoService lottoService) {
        this.winningLottoService = winningLottoService;
        this.lottoService = lottoService;
    }

    public void createLottoList(LottoListCreateDto lottoListCreateDto) {
        lottoService.createLotto(lottoListCreateDto);
    }

    public void deleteLottoList() {
        lottoService.deleteAll();
    }

    public List<LottoDto> getLottoList() {
        return lottoService.getLottoList();
    }

    public void createWinningLotto(WinningLottoCreateDto winningLottoCreateDto) {
        winningLottoService.createWinningLotto(winningLottoCreateDto);
    }

    public ResultDto getResults() {
        return lottoService.getResults();
    }
}
