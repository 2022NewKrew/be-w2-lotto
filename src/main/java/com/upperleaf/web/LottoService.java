package com.upperleaf.web;

import com.upperleaf.domain.LottoMatcher;
import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.LottoResult;
import com.upperleaf.domain.LottoSeller;
import com.upperleaf.domain.lotto.LottoWinningNumber;
import com.upperleaf.domain.lotto.Lottos;
import com.upperleaf.domain.lotto.create.CustomLottoStrategy;
import com.upperleaf.web.repository.LottoRepository;
import com.upperleaf.web.dto.LottoStatisticsInfo;
import com.upperleaf.web.dto.LottosInfo;

import java.sql.SQLException;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final LottoStatisticsService statisticsService;
    private final LottoSeller lottoSeller;

    public LottoService(LottoSeller seller, LottoRepository lottoRepository, LottoStatisticsService statisticsService) {
        this.lottoSeller = seller;
        this.lottoRepository = lottoRepository;
        this.statisticsService = statisticsService;
    }

    public LottosInfo buyLotto(LottoPaymentInfo paymentInfo) throws SQLException {
        Lottos lottos = lottoSeller.sell(paymentInfo, new CustomLottoStrategy(paymentInfo.getLottoNumbers()));
        lottos = lottoRepository.saveLottos(lottos);
        return new LottosInfo(lottos);
    }

    public LottoStatisticsInfo matchLotto(LottoWinningNumber winningNumber, Long lottoId) throws SQLException {
        Lottos lottos = lottoRepository.findById(lottoId);
        LottoMatcher lottoMatcher = new LottoMatcher(lottos, winningNumber);
        LottoResult lottoResult = statisticsService.getLottoResult(lottoMatcher);
        return new LottoStatisticsInfo(lottoResult);
    }
}
