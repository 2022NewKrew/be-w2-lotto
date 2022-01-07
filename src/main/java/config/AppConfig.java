package config;

import repository.LottoStatisticRepository;
import repository.LottoStatisticRepositoryInMemory;
import service.LottoService;
import service.LottoServiceImpl;

/**
 * 의존성을 관리합니다.
 */
public class AppConfig {

    public LottoStatisticRepository lottoRepository() {
        return new LottoStatisticRepositoryInMemory();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }
}
