package lotto.view;

import lotto.domain.Lotto;

import java.util.Scanner;

public class LottoViewInput {
    static public Integer lottoInitialInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        return sc.nextInt();
    }
}
