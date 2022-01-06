package view;

import controller.BuyLotto;
import domain.LottoPack;

import java.util.Scanner;

public class LottoInput {
    private static final Scanner sc = new Scanner(System.in);

    public static LottoPack inputBuyLottoPrize() {
        System.out.println("구입 금액을 입력해 주세요.");
        return BuyLotto.buy(sc.nextInt());
    }

    public static String inputLastPrizeNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        return sc.nextLine();
    }
    public static int inputBonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

}
