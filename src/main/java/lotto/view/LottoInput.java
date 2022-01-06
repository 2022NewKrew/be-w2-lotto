package lotto.view;

import lotto.domain.DefaultLotto;
import lotto.domain.Lotto;

import java.util.Scanner;

public class LottoInput {
    Scanner sc;

    public LottoInput() {
        sc = new Scanner(System.in);
    }

    public int enterMoney() {
        return sc.nextInt();
    }

    public Lotto enterPastWinningLotto() {
        Lotto lotto = new DefaultLotto();
//        String lottoString = "1, 2, 3, 4, 5, 6";
        String lottoString = sc.next();
        lotto.initialize(lottoString);
        return lotto;
    }

    public int enterBonusNumber() {
        return sc.nextInt();
    }
}
