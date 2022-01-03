package lotto.view;

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

            List<Integer> winningNumbers = inputWinningNumbers(sc);
            System.out.println(lottoView.printLottoResult(winningNumbers));
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

    private List<Integer> inputWinningNumbers(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != COUNT_OF_NUMBER.getValue()) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
        if (winningNumbers.stream().anyMatch(number -> number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException("번호의 범위는 1~45 입니다.");
        }
    }
}