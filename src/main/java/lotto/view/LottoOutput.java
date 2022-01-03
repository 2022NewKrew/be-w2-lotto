package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;

public class LottoOutput {
    public void printEnterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumberOfLotto(int count) {
        System.out.printf("%d개를 구매했습니다.", count);
    }

    public void printLottos(ArrayList<Lotto> lottos) {
        System.out.println(lottos);
    }

    public void printEnterPastWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printWinningStatistic() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("총 수익률은 30%입니다");

    }
}
