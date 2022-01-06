package service;

import dto.LottoListCreateDto;
import dto.LottoDto;
import dto.ResultDto;

import java.util.List;

public interface LottoService {
    void createLotto(LottoListCreateDto lotto);
    List<LottoDto> getLottoList();
    ResultDto getResults();
    void deleteAll();
}
