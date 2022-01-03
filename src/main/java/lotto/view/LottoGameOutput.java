package lotto.view;

import lotto.domain.PlayerLottoList;

public class LottoGameOutput {

    public static void printLottoNumbers(int numberOfLotto, PlayerLottoList playerLottoList) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        playerLottoList.getLottoList().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
