package back.service;

import back.domain.Lotto;
import back.domain.Prize;
import back.domain.WinningLotto;
import dto.LottoCreateDto;
import dto.LottoDto;
import back.repository.LottoRepository;
import back.repository.WinningLottoRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoServiceImpl implements LottoService {
    private final WinningLottoRepository winningLottoRepository;
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(WinningLottoRepository winningLottoRepository,
                            LottoRepository lottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void createLotto(LottoCreateDto lottoCreateDto) {
        Lotto lotto = new Lotto(
                lottoCreateDto.getLottoSequence(),
                lottoCreateDto.getAutoCreated());
        lottoRepository.save(lotto);
    }

    @Override
    public List<LottoDto> getLottoList() {
        List<Lotto> lottoList = lottoRepository.findAll();
        return lottoList.stream()
                .map(LottoDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<Prize> getResults() {
        List<Lotto> lottoList = lottoRepository.findAll();
        WinningLotto winningLotto = winningLottoRepository.find();

        return lottoList.stream()
                .map(lotto -> lotto.getResult(winningLotto))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
