package com.upperleaf.web;

import com.upperleaf.domain.LottoMatcher;
import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.LottoSeller;
import com.upperleaf.domain.LottoStatistics;
import com.upperleaf.domain.lotto.LottoWinningNumber;
import com.upperleaf.domain.lotto.Lottos;
import com.upperleaf.domain.lotto.create.WebLottoCreateStrategy;
import com.upperleaf.web.dto.LottoStatisticsInfo;
import com.upperleaf.web.dto.LottosInfo;
import spark.Session;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static final LottoService INSTANCE = new LottoService();
    private static final int LOTTO_PRICE = 1000;

    public static LottoService getInstance() {
        return INSTANCE;
    }

    public LottosInfo buyLotto(LottoPaymentInfo paymentInfo, String manualNumbers, Session session) {
        LottoSeller lottoSeller = new LottoSeller(LOTTO_PRICE);
        Lottos lottos = lottoSeller.sell(paymentInfo, new WebLottoCreateStrategy(convertNumbersToList(manualNumbers)));
        session.attribute("lottos", lottos);
        session.attribute("paymentInfo", paymentInfo);
        return new LottosInfo(lottos);
    }

    public LottoStatisticsInfo matchLotto(LottoWinningNumber winningNumber, Session session) {
        Lottos lottos = session.attribute("lottos");
        LottoPaymentInfo paymentInfo = session.attribute("paymentInfo");
        LottoStatistics statistics = new LottoStatistics(new LottoMatcher(lottos, winningNumber));

        return new LottoStatisticsInfo(statistics.groupByLottoRanking(), statistics.getAllWinningProfitRate(paymentInfo));
    }

    private List<List<Integer>> convertNumbersToList(String manualNumber) {
        return Arrays.stream(manualNumber.split("\n"))
                .map(numbers -> Arrays.stream(numbers.split(",")))
                .map(numberStream -> numberStream.map(num -> Integer.parseInt(num.trim())))
                .map(numStream -> numStream.collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
