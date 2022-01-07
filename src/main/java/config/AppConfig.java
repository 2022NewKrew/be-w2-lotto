package config;

import repository.*;
import service.LottoService;
import service.LottoServiceImpl;

/**
 * 의존성을 관리합니다.
 */
public class AppConfig {

    public LottoRepository lottoRepository() {
        return new LottoRepositoryJdbcH2();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoStatisticRepository(), lottoRepository());
    }

    public LottoStatisticRepository lottoStatisticRepository() {
        return new LottoStatisticRepositoryJdbcH2();
    }
}
