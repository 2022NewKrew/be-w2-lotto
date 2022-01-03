package lotto.view;

import java.util.Scanner;

public class LottoGameInput {

    public static int inputPurchaseAmount(Scanner scanner){
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
