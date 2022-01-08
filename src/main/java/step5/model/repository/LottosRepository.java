package step5.model.repository;

import step5.model.domain.Lottos;

public interface LottosRepository extends Repository{
    Lottos selectAllLottos();
    void insertLottos(Lottos lottos);
}
