package back.service;

import back.domain.WinningLotto;
import dto.WinningLottoCreateDto;
import back.repository.WinningLottoRepository;

public class WinningLottoServiceImpl implements WinningLottoService{
    private final WinningLottoRepository winningLottoRepository;

    public WinningLottoServiceImpl(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public void createWinningLotto(WinningLottoCreateDto winningLottoCreateDto) {
        WinningLotto winningLotto = new WinningLotto(
                winningLottoCreateDto.getSequence(),
                winningLottoCreateDto.getBonusNumber());
        winningLottoRepository.save(winningLotto);
    }
}
