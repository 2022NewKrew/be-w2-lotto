package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class LottoView {

    public void printLottos(List<LottoNumbers> lottos, int numOfManualLottos) {
        System.out.println("수동으로 " + numOfManualLottos +
                "개, 자동으로 " + (lottos.size() - numOfManualLottos) +
                "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public void printResult(HashMap<Rank, Integer> matchMap, int profitRate) {
        System.out.println("당첨 통계");
        System.out.println("===========");
        for (Rank rank : Rank.values()) {
            printCntOfMatch(rank, matchMap);
        }
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private void printCntOfMatch(Rank rank, HashMap<Rank, Integer> matchMap) {
        if (rank.equals(Rank.NONE)) return;

        System.out.print(rank.getCntOfMatch() + "개 일치");
        if (rank.equals(Rank.SECOND))
            System.out.print(", 보너스 볼 일치");
        System.out.println(" (" + rank.getWinningMoney() + "원) - " + matchMap.get(rank) + "개");
    }

    public void askMoneyAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public void askManualNumOfLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void askManualLottoNumbers() { System.out.println("수동으로 구매할 번호를 입력해 주세요."); }

    public void askWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void askBonusWinningLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void warnInvalidMoneyAmount() {
        System.out.println("잘못된 금액입니다! 다시 입력해주세요.");
    }

    public void warnInvalidManualNumOfLotto() {
        System.out.println("잘못된 수동 로또 수량입니다! 다시 입력해주세요.");
    }

    public void warnInvalidManualLottoNumbers() {
        System.out.println("잘못된 로또 번호입니다! 다시 입력해주세요.");
    }

    public void warnInvalidWinningLottoNumbers() {
        System.out.println("잘못된 당첨 번호입니다! 다시 입력해주세요.");
    }

    public void warnInvalidBonusWinningLottoNumbers() {
        System.out.println("잘못된 보너스 당첨 번호입니다! 다시 입력해주세요.");
    }
}
