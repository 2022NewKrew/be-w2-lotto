package config;

import repository.LottoRepository;
import repository.LottoRepositoryInMemory;
import service.LottoService;
import service.LottoServiceImpl;

/**
 * 의존성을 관리합니다.
 */
public class AppConfig {

    public LottoRepository lottoRepository() {
        return new LottoRepositoryInMemory();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }
}
