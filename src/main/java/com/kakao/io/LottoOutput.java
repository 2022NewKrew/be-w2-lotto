package com.kakao.io;

import com.kakao.data.MatchBall;
import com.kakao.data.io.LottoOutputData;
import com.kakao.model.Lotto;
import com.kakao.model.LottoWinning;
import com.kakao.model.LottoWinningReward;
import com.kakao.model.Lottos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

class LottoOutput {
    private LottoOutput() {}

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printString (String str) {
        try {
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printResult (Lottos lottos) {
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
    public static void printLottoWinning(Integer moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning){
        StringBuilder sb = new StringBuilder();
        sb.append(LottoOutputData.RESULT_COMMENT_OF_WINNING);
        sb.append(LottoOutputData.RESULT_DIVISION_LINE_OF_WINNING);

        List<Integer> countOfWinningLottos = appendWinningResult(sb, lottos, lottoWinning);

        sb.append(appendYieldRate(moneyToBuyLotto, countOfWinningLottos));

        try {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 당첨 결과 출력
    private static List<Integer> appendWinningResult(StringBuilder sb, Lottos lottos, LottoWinning lottoWinning) {
        List<Integer> countOfWinningLottos = lottos.matchLottosAreWinning(lottoWinning);
        for(MatchBall matchBall: MatchBall.values()){
            sb.append(appendEachWinningResult(matchBall, countOfWinningLottos));
        }
        return countOfWinningLottos;
    }
    private static String appendEachWinningResult(MatchBall matchBall, List<Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();
        int countOfMatchNumber = winningReward.getCountOfMatchNumber();
        int rewardPrice = winningReward.getRewardPrice();
        int count = countOfWinningLottos.get(countOfMatchNumber);

        return String.format(LottoOutputData.RESULT_FORMAT_OF_WINNING_MATCH, countOfMatchNumber, rewardPrice, count);
    }

    // 이득 비율 출력
    private static String appendYieldRate(Integer moneyToBuyLotto, List<Integer> countOfWinningLottos) {
        int sumOfReward = 0 ;
        for(MatchBall matchBall: MatchBall.values()) {
            sumOfReward += sumOfWinningReward(matchBall, countOfWinningLottos);
        }

        int yeildRate = (sumOfReward - moneyToBuyLotto) * 100 / moneyToBuyLotto;
        return String.format(LottoOutputData.RESULT_FORMAT_OF_YIELD_RATE, yeildRate);
    }
    private static int sumOfWinningReward(MatchBall matchBall, List<Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();

        int countOfMatchNumber = winningReward.getCountOfMatchNumber();
        int rewardPrice = winningReward.getRewardPrice();
        int count = countOfWinningLottos.get(countOfMatchNumber);

        return rewardPrice * count;
    }
}
