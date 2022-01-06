package com.upperleaf.web;

import com.upperleaf.domain.LottoSeller;
import com.upperleaf.domain.LottoStatistics;
import com.upperleaf.web.repository.LottoRepository;
import com.upperleaf.web.repository.LottoResultRepository;

import static com.upperleaf.domain.lotto.create.LottoConstants.*;

public class LottoFactory {

    private static final LottoFactory instance = new LottoFactory();

    public static LottoFactory getInstance() {
        return instance;
    }

    public LottoService lottoService() {
        return new LottoService(lottoSeller(), lottoRepository(), lottoStatisticsService());
    }

    public LottoSeller lottoSeller() {
        return new LottoSeller(LOTTO_PRICE);
    }

    public LottoRepository lottoRepository() {
        return new LottoRepository();
    }

    public LottoStatisticsService lottoStatisticsService() {
        return new LottoStatisticsService(lottoStatistics(), lottoResultRepository());
    }

    public LottoStatistics lottoStatistics() {
        return new LottoStatistics();
    }

    public LottoResultRepository lottoResultRepository() {
        return new LottoResultRepository();
    }
}
