package back.repository;

import back.database.RogerSQL;
import back.domain.WinningLotto;

public class WinningLottoRepositoryImpl implements WinningLottoRepository{
    private final RogerSQL rogerSQL;

    public WinningLottoRepositoryImpl(RogerSQL rogerSQL) {
        this.rogerSQL = rogerSQL;
    }

    @Override
    public void save(WinningLotto winningLotto) {
        rogerSQL.save(winningLotto);
    }

    @Override
    public WinningLotto find() {
        return rogerSQL.find();
    }
}
