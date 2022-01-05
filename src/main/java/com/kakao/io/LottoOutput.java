package com.kakao.io;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.kakao.data.MatchBall;
=======
import com.kakao.data.LottoWinningData;
>>>>>>> 4f43f8b (1차 Commit)
=======
import com.kakao.data.MatchBall;
>>>>>>> 573229f (2일차 PR)
import com.kakao.data.io.LottoOutputData;
import com.kakao.helper.MapHelper;
import com.kakao.model.Lotto;
import com.kakao.model.LottoWinning;
import com.kakao.model.LottoWinningReward;
<<<<<<< HEAD
=======
import com.kakao.data.io.LottoOutputData;
import com.kakao.model.Lotto;
>>>>>>> edb2074 (1일차 중간 PR)
=======
>>>>>>> 4f43f8b (1차 Commit)
import com.kakao.model.Lottos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

class LottoOutput {
<<<<<<< HEAD
<<<<<<< HEAD
    private LottoOutput() {}

=======
>>>>>>> edb2074 (1일차 중간 PR)
=======
    private LottoOutput() {}

>>>>>>> 4f43f8b (1차 Commit)
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4f43f8b (1차 Commit)

    // winning 정보 출력
    public static void printLottoWinning(Integer moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning){
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
<<<<<<< HEAD
    private static List<Integer> appendWinningResult(StringBuilder sb, Lottos lottos, LottoWinning lottoWinning) {
        List<Integer> countOfWinningLottos = lottos.matchLottosAreWinning(lottoWinning);
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private static Map<LottoWinningReward, Integer> appendWinningResult(StringBuilder sb, Lottos lottos, LottoWinning lottoWinning) {
        Map<LottoWinningReward, Integer> countOfWinningLottos = lottos.matchLottosAreWinning(lottoWinning);
>>>>>>> 5806f60 (2일차 PR)
        for(MatchBall matchBall: MatchBall.values()){
            sb.append(appendEachWinningResult(matchBall, countOfWinningLottos));
        }
        return countOfWinningLottos;
    }
    private static String appendEachWinningResult(MatchBall matchBall, Map<LottoWinningReward, Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();
=======
        for(LottoWinningReward winningReward: LottoWinningData.lottoWinningRewards){
            sb.append(appendEachWinningResult(winningReward, countOfWinningLottos));
        }
        return countOfWinningLottos;
    }
    private static String appendEachWinningResult(LottoWinningReward winningReward, List<Integer> countOfWinningLottos) {
>>>>>>> 4f43f8b (1차 Commit)
=======
        for(MatchBall matchBall: MatchBall.values()){
            sb.append(appendEachWinningResult(matchBall, countOfWinningLottos));
        }
        return countOfWinningLottos;
    }
    private static String appendEachWinningResult(MatchBall matchBall, List<Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();
>>>>>>> 573229f (2일차 PR)
        int countOfMatchNumber = winningReward.getCountOfMatchNumber();
        int rewardPrice = matchBall.getRewardPrice();
        int count = MapHelper.getIntegerValue(countOfWinningLottos, winningReward);

        String resultFormat = LottoOutputData.RESULT_FORMAT_OF_WINNING_MATCH;
        if(winningReward.getUseBaseBall()){
            resultFormat = LottoOutputData.RESULT_FORMAT_OF_WINNING_MATCH_WITH_BONUS_BALL;
        }

        return String.format(resultFormat, countOfMatchNumber, rewardPrice, count);
    }

    // 이득 비율 출력
<<<<<<< HEAD
    private static String appendYieldRate(Integer moneyToBuyLotto, List<Integer> countOfWinningLottos) {
        int sumOfReward = 0 ;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private static String appendYieldRate(Integer moneyToBuyLotto, Map<LottoWinningReward, Integer> countOfWinningLottos) {
        long sumOfReward = 0 ;
>>>>>>> 5806f60 (2일차 PR)
        for(MatchBall matchBall: MatchBall.values()) {
            sumOfReward += sumOfWinningReward(matchBall, countOfWinningLottos);
        }

        long yeildRate = (sumOfReward - moneyToBuyLotto) * 100 / moneyToBuyLotto;
        return String.format(LottoOutputData.RESULT_FORMAT_OF_YIELD_RATE, yeildRate);
    }
    private static int sumOfWinningReward(MatchBall matchBall, Map<LottoWinningReward, Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();

        int rewardPrice = matchBall.getRewardPrice();
        int count = MapHelper.getIntegerValue(countOfWinningLottos, winningReward);

        return rewardPrice * count;
    }
=======
>>>>>>> edb2074 (1일차 중간 PR)
=======
        for(LottoWinningReward winningReward: LottoWinningData.lottoWinningRewards) {
            int countOfMatchNumber = winningReward.getCountOfMatchNumber();
            int rewardPrice = winningReward.getRewardPrice();
            int count = countOfWinningLottos.get(countOfMatchNumber);

            sumOfReward += rewardPrice * count;
=======
        for(MatchBall matchBall: MatchBall.values()) {
            sumOfReward += sumOfWinningReward(matchBall, countOfWinningLottos);
>>>>>>> 573229f (2일차 PR)
        }

        int yeildRate = (sumOfReward - moneyToBuyLotto) * 100 / moneyToBuyLotto;
        return String.format(LottoOutputData.RESULT_FORMAT_OF_YIELD_RATE, yeildRate);
    }
<<<<<<< HEAD
>>>>>>> 4f43f8b (1차 Commit)
=======
    private static int sumOfWinningReward(MatchBall matchBall, List<Integer> countOfWinningLottos) {
        LottoWinningReward winningReward = matchBall.getLottoWinningReward();

        int countOfMatchNumber = winningReward.getCountOfMatchNumber();
        int rewardPrice = winningReward.getRewardPrice();
        int count = countOfWinningLottos.get(countOfMatchNumber);

        return rewardPrice * count;
    }
>>>>>>> 573229f (2일차 PR)
}
