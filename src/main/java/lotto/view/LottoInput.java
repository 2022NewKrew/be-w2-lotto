package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.userinput.PurchasedLottoInput;
import lotto.domain.userinput.WinningLottoInput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInput {
    public void lottoSimulation() {
        try (Scanner sc = new Scanner(System.in)) {
            PurchasedLottoInput purchasedLottoInput = userInputPurchasedLotto(sc);
            LottoView lottoView = new LottoView(purchasedLottoInput);
            System.out.println(lottoView.printPurchasedLotto());

            WinningLottoInput winningLottoInput = userInputWinningLotto(sc);
            System.out.println(lottoView.printLottoResult(winningLottoInput));
        }
    }

    private PurchasedLottoInput userInputPurchasedLotto(Scanner sc) {
        int purchasePrice = inputIntValue(sc, "구입금액을 입력해 주세요.");
        int countOfManualLotto = inputIntValue(sc, "수동으로 구매할 로또 수를 입력해 주세요.");
        List<Lotto> manualLottoBundle = inputManualLottoBundle(sc, countOfManualLotto);
        return new PurchasedLottoInput(purchasePrice, countOfManualLotto, manualLottoBundle);
    }

    private WinningLottoInput userInputWinningLotto(Scanner sc) {
        Lotto winningTicket = inputWinningTicket(sc);
        int bonusBall = inputIntValue(sc, "보너스 볼을 입력해 주세요.");
        return new WinningLottoInput(winningTicket, bonusBall);
    }

    private List<Lotto> inputManualLottoBundle(Scanner sc, int countOfManualLotto) {
        nullInput(sc);
        if (countOfManualLotto == 0) {
            return Collections.EMPTY_LIST;
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, countOfManualLotto)
                .mapToObj(lottoTicket -> inputLottoTicket(sc)).collect(Collectors.toList());
    }

    private Lotto inputWinningTicket(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoTicket(sc);
    }

    private int inputIntValue(Scanner sc, String expression) {
        System.out.println(expression);
        return sc.nextInt();
    }

    private Lotto inputLottoTicket(Scanner sc) {
        return new Lotto(Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void nullInput(Scanner sc) {
        sc.nextLine();
    }
}