package view;

import domain.Lotto;
import domain.Number;
import domain.WinningLotto;
import domain.WinningLottoManual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Symbol.*;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public InputView() {
    }

    public int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        int purchaseAmount = sc.nextInt();
        sc.nextLine();
        return purchaseAmount;
    }

    public int getManualLottoCount() {
        System.out.println();
        System.out.println(MANNUAL_COUNT_MESSAGE);
        int manualLottoCount = sc.nextInt();
        sc.nextLine();
        return manualLottoCount;
    }

    public WinningLotto getWinningLotto() {
        Lotto winningLotto = getManualLotto(LAST_WEEK_WINNING_NUMBER_MESSAGE);
        Number bonusNumber = getBonusNumber();
        return new WinningLottoManual(winningLotto, bonusNumber);
    }

    public Lotto getManualLotto(String message) {
        List<Number> inputNumberList = getNumberList(message);
        ArrayList<Number> inputNumberArrayList = new ArrayList<Number>();
        inputNumberArrayList.addAll(inputNumberList);
        return new Lotto(inputNumberArrayList);
    }

    public List<Number> getNumberList(String Message) {
        System.out.println();
        System.out.println(Message);
        String str = sc.nextLine();

        return Arrays.stream(str.split(COMMA))
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(n -> new Number(n))
                .collect(Collectors.toList());
    }

    public Number getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        return new Number(bonusNumber);
    }
}
