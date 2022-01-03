package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoGameOutput {

    public static void printLottoNumbers(int numberOfLotto, List<Lotto> lottoList) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        lottoList.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
