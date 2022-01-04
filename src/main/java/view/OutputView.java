package view;

import model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum LottoMessages {
    FIFTH("3개 일치 (5000원)- "),
    FORTH("4개 일치 (50000원)- "),
    THIRD("5개 일치 (1500000원)- "),
    SECOND("5개 일치, 보너스 볼 일치(30000000원) - "),
    FIRST("6개 일치 (2000000000원)- ");

    private String message;

    LottoMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class OutputView {
    private enum lottoRank {}

    private static int LOTTO_PRICE = 1000;
    private static int RANK_MAX_COUNT = 5;

    private OutputView() {
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            printLotto(lottos.get(i));
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printLottoWinningStats(List<Integer> rankResults, long totalWinningAmount, int lottoCount) {
        List<String> rankMessage = new ArrayList<>(Arrays.asList(LottoMessages.FIFTH.getMessage(), LottoMessages.FORTH.getMessage(), LottoMessages.THIRD.getMessage(), LottoMessages.SECOND.getMessage(), LottoMessages.FIRST.getMessage()));

        System.out.println("\n당첨 통계\n----------");
        for (int i = 0; i < RANK_MAX_COUNT; i++) {
            System.out.println((rankMessage.get(i) + rankResults.get(i) + "개"));
        }
        long yield = (totalWinningAmount - LOTTO_PRICE * lottoCount) / (LOTTO_PRICE * lottoCount) * 100;
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}

