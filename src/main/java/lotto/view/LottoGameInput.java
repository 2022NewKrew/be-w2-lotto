package lotto.view;

import lotto.domain.result.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoGameInput {

    public static int inputPurchaseAmount(Scanner scanner){
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        return purchaseAmount;
    }

    public static WinningLotto inputWinningNumbers(Scanner scanner){
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();

        return new WinningLotto(Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static int inputBonusNumber(Scanner scanner){
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
