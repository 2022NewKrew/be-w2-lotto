package back.repository;

import back.domain.WinningLotto;

public interface WinningLottoRepository {
    void save(WinningLotto winningLotto);
    WinningLotto find();
}
