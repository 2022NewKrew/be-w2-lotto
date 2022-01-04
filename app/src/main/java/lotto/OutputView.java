package lotto;

import java.util.List;

public class OutputView {
    public static final void printCountLotto(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }

    public static final void printLottoList(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
