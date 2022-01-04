package lotto.view;

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
        Lotto lotto = new Lotto();
//        String lottoString = "1, 2, 3, 4, 5, 6";
        String lottoString = sc.next();
        lotto.initialize(lottoString);
        return lotto;
    }
}
