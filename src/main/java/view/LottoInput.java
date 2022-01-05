package view;

import controller.BuyLotto;
import controller.CheckPrize;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    private static Scanner sc = new Scanner(System.in);

    public static void inputBuyLottoPrize(){
        System.out.println("구입 금액을 입력해 주세요.");
        BuyLotto buyLotto = new BuyLotto(sc.nextInt());
    }

    public static void inputLastPrizeNum(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        CheckPrize checkPrize = new CheckPrize(BuyLotto.lottoPack,sc.next());
    }
}
