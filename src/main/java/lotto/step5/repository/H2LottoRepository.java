package lotto.step5.repository;

import lotto.step1.model.Lotto;
import lotto.step1.repository.LottoRepository;
import lotto.step5.dao.LottoDAO;

import java.util.Optional;

public class H2LottoRepository extends LottoRepository {

    private final LottoDAO lottoDAO = new LottoDAO();

    @Override
    public Optional<Lotto> findById(Long lottoId) {
        final Optional<Lotto> optionalLotto = super.findById(lottoId);

        if (optionalLotto.isPresent()) {
            return optionalLotto;
        }

        return Optional.of(lottoDAO.read(lottoId));
    }

    @Override
    public void save(Lotto lotto) {
        super.save(lotto);

        lottoDAO.create(lotto);
    }

    public void update(Lotto lotto) {
        super.update(lotto);

        lottoDAO.update(lotto);
    }
}
