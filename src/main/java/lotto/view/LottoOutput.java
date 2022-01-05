package lotto.view;

import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoOutput {
    LottoRank[] lottoRanks;

    public LottoOutput() {
        lottoRanks = LottoRank.values();
    }

    public void printEnterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumberOfLotto(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printEnterPastWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printWinningStatistic(LottoStatistic lottoStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Integer, Long> winningCountMap = lottoStatistic.getWinningCountMap();
        for (LottoRank lottoRank : lottoRanks) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", lottoRank.getMatch(), lottoRank.getMoney(), winningCountMap.get(lottoRank.getMatch()));
        }
        System.out.printf("총 수익률은 %d%%입니다\n", lottoStatistic.getProfitPercentage());
    }

    public void printEnterBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}
