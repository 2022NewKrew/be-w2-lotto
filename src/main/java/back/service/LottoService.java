package back.service;

import back.domain.Prize;
import dto.LottoCreateDto;
import dto.LottoDto;

import java.util.List;

public interface LottoService {
    void createLotto(LottoCreateDto lotto);
    List<LottoDto> getLottoList();
    List<Prize> getResults();
}
