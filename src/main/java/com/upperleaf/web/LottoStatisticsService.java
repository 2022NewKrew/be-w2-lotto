package com.upperleaf.web;

import com.upperleaf.domain.LottoMatcher;
import com.upperleaf.domain.LottoResult;
import com.upperleaf.domain.LottoStatistics;
import com.upperleaf.web.repository.LottoResultRepository;

import java.sql.SQLException;


public class LottoStatisticsService {

    private final LottoResultRepository lottoResultRepository;
    private final LottoStatistics lottoStatistics;

    public LottoStatisticsService(LottoStatistics lottoStatistics, LottoResultRepository lottoResultRepository) {
        this.lottoStatistics = lottoStatistics;
        this.lottoResultRepository = lottoResultRepository;
    }

    public LottoResult getLottoResult(LottoMatcher lottoMatcher) throws SQLException {
        LottoResult lottoResult = lottoStatistics.getLottoResult(lottoMatcher);
        lottoResult = lottoResultRepository.saveLottoResult(lottoResult);
        return lottoResult;
    }
}
