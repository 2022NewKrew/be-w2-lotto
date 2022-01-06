package repository;

import domain.WinningLotto;

public interface WinningLottoRepository {
    void save(WinningLotto winningLotto);
    WinningLotto find();
}
