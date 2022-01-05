package back.repository;

import back.database.RogerSQL;
import back.domain.Lotto;

import java.util.List;

public class LottoRepositoryImpl implements LottoRepository {
    private final RogerSQL rogerSQL;

    public LottoRepositoryImpl(RogerSQL rogerSQL) {
        this.rogerSQL = rogerSQL;
    }

    @Override
    public void save(Lotto lotto) {
        rogerSQL.save(lotto);
    }

    @Override
    public List<Lotto> findAll() {
        return rogerSQL.findAll();
    }
}
