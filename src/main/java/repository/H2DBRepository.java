package repository;


import repository.dao.LottoDao;
import service.lotto.LottoBundle;

public class H2DBRepository implements Repository {
    private final LottoDao lottoDao = new LottoDao();

    @Override
    public void save(LottoBundle lottoBundle) {
        lottoDao.create(lottoBundle);
    }

    @Override
    public LottoBundle findById(Long id) {
        return lottoDao.read(id);
    }

    @Override
    public void update(LottoBundle lottoBundle) {
        lottoDao.update(lottoBundle);
    }
}
