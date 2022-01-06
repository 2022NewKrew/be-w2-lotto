package com.upperleaf.web;

import com.upperleaf.domain.LottoSeller;
import com.upperleaf.domain.LottoStatistics;

import static com.upperleaf.domain.lotto.create.LottoConstants.*;

public class LottoFactory {

    private static final LottoFactory instance = new LottoFactory();

    public static LottoFactory getInstance() {
        return instance;
    }

    public LottoService lottoService() {
        return new LottoService(lottoSeller(), lottoStatistics());
    }

    public LottoSeller lottoSeller() {
        return new LottoSeller(LOTTO_PRICE);
    }

    public LottoStatistics lottoStatistics() {
        return new LottoStatistics();
    }
}
