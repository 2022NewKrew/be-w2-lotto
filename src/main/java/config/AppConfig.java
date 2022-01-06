package config;

import repository.LottoRepository;
import repository.LottoRepositoryInMemory;
import service.LottoService;
import service.LottoServiceImpl;

public class AppConfig {

    public LottoRepository lottoRepository() {
        return new LottoRepositoryInMemory();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }
}
