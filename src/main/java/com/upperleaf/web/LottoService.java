package com.upperleaf.web;

import com.upperleaf.domain.LottoMatcher;
import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.LottoSeller;
import com.upperleaf.domain.LottoStatistics;
import com.upperleaf.domain.lotto.LottoRanking;
import com.upperleaf.domain.lotto.LottoWinningNumber;
import com.upperleaf.domain.lotto.Lottos;
import com.upperleaf.domain.lotto.create.CustomLottoStrategy;
import com.upperleaf.web.dto.LottoStatisticsInfo;
import com.upperleaf.web.dto.LottosInfo;
import spark.Session;

import java.util.Map;

public class LottoService {

    private static final LottoService INSTANCE = LottoFactory.getInstance().lottoService();

    private final LottoSeller lottoSeller;
    private final LottoStatistics lottoStatistics;

    public LottoService(LottoSeller lottoSeller, LottoStatistics statistics) {
        this.lottoSeller = lottoSeller;
        this.lottoStatistics = statistics;
    }

    public static LottoService getInstance() {
        return INSTANCE;
    }

    public LottosInfo buyLotto(LottoPaymentInfo paymentInfo, Session session) {
        Lottos lottos = lottoSeller.sell(paymentInfo, new CustomLottoStrategy(paymentInfo.getLottoNumbers()));
        session.attribute("lottos", lottos);
        session.attribute("paymentInfo", paymentInfo);
        return new LottosInfo(lottos);
    }

    public LottoStatisticsInfo matchLotto(LottoWinningNumber winningNumber, Session session) {
        Lottos lottos = session.attribute("lottos");
        LottoPaymentInfo paymentInfo = session.attribute("paymentInfo");
        LottoMatcher matcher = new LottoMatcher(lottos, winningNumber);

        Map<LottoRanking, Long> groupRanking = lottoStatistics.groupByLottoRanking(matcher);
        long profitRate = lottoStatistics.getAllWinningProfitRate(matcher, paymentInfo);
        return new LottoStatisticsInfo(groupRanking, profitRate);
    }
}
