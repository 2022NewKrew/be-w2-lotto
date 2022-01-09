package view;

import controller.BuyLotto;
import domain.LottoPack;

import java.util.Scanner;

public class LottoInput {
    private LottoInput() {
    }

    private static final Scanner sc = new Scanner(System.in);

    public static LottoPack inputBuyLottoPrize() {
        System.out.println("구입 금액을 입력해 주세요.");
        return BuyLotto.buy(sc.nextInt());
    }

    public static String inputLastPrizeNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumbers();
    }

    public static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        int inputInt = sc.nextInt();
        sc.nextLine();
        return inputInt;

    }

    public static String inputManualLotto(int Num) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        StringBuilder manualLottoStringBuilder = new StringBuilder();
        for (int i = 0; i < Num; i++) {
            manualLottoStringBuilder.append(inputLottoNumbers()).append("\n");
        }
        return manualLottoStringBuilder.toString();
    }

    public static String inputLottoNumbers() {
        return sc.nextLine();
    }


    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

}
