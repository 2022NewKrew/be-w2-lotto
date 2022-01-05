package view;

import domain.Lotto;
import domain.Number;
import domain.WinningLotto;
import domain.WinningLottoManual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
        ArrayList<Number> inputNumberList = getNumberList(message);
        return new Lotto(inputNumberList);
    }

    public ArrayList<Number> getNumberList(String Message) {
        System.out.println();
        System.out.println(Message);
        String str = sc.nextLine();
        String[] strList = str.replace(SPACE, BLANK).split(COMMA);
        int[] nums = Arrays.stream(strList)
                .mapToInt(Integer::parseInt).toArray();

        ArrayList<Number> numberList = new ArrayList<>();
        for (int num : nums) {
            numberList.add(new Number(num));
        }
        return numberList;
    }

    public Number getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        return new Number(bonusNumber);
    }
}
