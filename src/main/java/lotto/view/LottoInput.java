package lotto.view;

import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.domain.LottoInfo.*;

public class LottoInput {
    public void lottoSimulation() {
        try (Scanner sc = new Scanner(System.in)) {
            int purchasePrice = inputPurchasePrice(sc);
            LottoView lottoView = new LottoView(purchasePrice);
            System.out.println(lottoView.printPurchasedLotto());

            nullInput(sc);

            WinningLotto winningLotto = inputWinningLotto(sc);
            System.out.println(lottoView.printLottoResult(winningLotto));
        }
    }

    private void nullInput(Scanner sc) {
        sc.nextLine();
    }

    private int inputPurchasePrice(Scanner sc) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = sc.nextInt();
        validatePurchasePrice(purchasePrice);
        return purchasePrice;
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < PRICE_OF_LOTTO.getValue()) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }
    }

    private WinningLotto inputWinningLotto(Scanner sc){
        List<Integer> numbers = inputWinningNumbers(sc);
        int bonusBall = inputBonusBall(sc);
        return new WinningLotto(numbers, bonusBall);
    }

    private List<Integer> inputWinningNumbers(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int inputBonusBall(Scanner sc) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}