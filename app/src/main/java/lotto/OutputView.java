package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final void printCountLotto(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }

    public static final void printLottoList(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static final void printResult(Map<Integer, Integer> result) {
        System.out.println("당첨 통계\n-------\n");
        result.forEach((key, value) -> {
            System.out.println(key + "개 일치 - " + value + "개");
        });

    }
}
