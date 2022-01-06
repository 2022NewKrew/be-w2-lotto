package com.kakao.io;


import com.kakao.data.LottoData;
import com.kakao.data.MatchBall;
import com.kakao.data.io.LottoOutputData;
import com.kakao.model.lotto.Lotto;
import com.kakao.model.LottoWinning;
import com.kakao.model.LottoWinningReward;
import com.kakao.model.Lottos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

class LottoOutput {
    private LottoOutput() {}

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void printString (String str) {
        if(str == null) {
            return;
        }
        try {
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printResult (Lottos lottos) {
        if(lottos == null) {
            return;
        }

        List<Lotto> lottoList = lottos.getLottoList();

        StringBuilder sb = new StringBuilder();
        printResultComment(sb, lottoList.size());
        printLottoData(sb, lottoList);

        try {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 출력문자열 생성
    private static void printResultComment(StringBuilder sb, int numberOfLottos) {
        String format = String.format(LottoOutputData.RESULT_COMMENT_OF_PURCHASE, numberOfLottos);
        sb.append(format);
    }
    private static void printLottoData(StringBuilder sb, List<Lotto> lottoList) {
        for(Lotto lotto: lottoList) {
            sb.append(lotto);
            sb.append("\n");
        }
    }

    // winning 정보 출력
    static void printLottoWinning(Integer moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning){
        if(moneyToBuyLotto == null || lottos == null || lottoWinning == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(LottoOutputData.RESULT_COMMENT_OF_WINNING);
        sb.append(LottoOutputData.RESULT_DIVISION_LINE_OF_WINNING);

        Map<LottoWinningReward, Integer> countOfWinningLottos = appendWinningResult(sb, lottos, lottoWinning);

        sb.append(appendYieldRate(moneyToBuyLotto, countOfWinningLottos));

        try {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 당첨 결과 출력
    private static Map<LottoWinningReward, Integer> appendWinningResult(StringBuilder sb, Lottos lottos, LottoWinning lottoWinning) {
        Map<LottoWinningReward, Integer> countOfWinningLottos = lottos.matchLottosAreWinning(lottoWinning);
        for(MatchBall matchBall: MatchBall.values()){
            sb.append(appendEachWinningResult(matchBall, countOfWinningLottos));
        }
        return countOfWinningLottos;
    }

    private static String appendEachWinningResult(MatchBall matchBall, Map<LottoWinningReward, Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();
        int countOfMatchNumber = winningReward.getCountOfMatchNumber();
        int rewardPrice = matchBall.getRewardPrice();
        int count = countOfWinningLottos.getOrDefault(winningReward, LottoData.DEFAULT_INTEGER_VALUE);

        String resultFormat = LottoOutputData.RESULT_FORMAT_OF_WINNING_MATCH;
        if(winningReward.getUseBaseBall()){
            resultFormat = LottoOutputData.RESULT_FORMAT_OF_WINNING_MATCH_WITH_BONUS_BALL;
        }

        return String.format(resultFormat, countOfMatchNumber, rewardPrice, count);
    }

    // 이득 비율 출력
    private static String appendYieldRate(Integer moneyToBuyLotto, Map<LottoWinningReward, Integer> countOfWinningLottos) {
        long sumOfReward = 0 ;
        for(MatchBall matchBall: MatchBall.values()) {
            sumOfReward += sumOfWinningReward(matchBall, countOfWinningLottos);
        }

        long yeildRate = (sumOfReward - moneyToBuyLotto) * 100 / moneyToBuyLotto;
        return String.format(LottoOutputData.RESULT_FORMAT_OF_YIELD_RATE, yeildRate);
    }

    private static int sumOfWinningReward(MatchBall matchBall, Map<LottoWinningReward, Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();

        int rewardPrice = matchBall.getRewardPrice();
        int count = countOfWinningLottos.getOrDefault(winningReward, LottoData.DEFAULT_INTEGER_VALUE);

        return rewardPrice * count;
    }
}
