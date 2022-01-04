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

    public InputView(){
    }

    public int getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        int purchaseAmount = sc.nextInt();
        sc.nextLine();
        return purchaseAmount;
    }

    public int getManualLottoCount(){
        System.out.println();
        System.out.println(MANNUAL_COUNT_MESSAGE);
        int ManualLottoCount = sc.nextInt();
        sc.nextLine();
        return ManualLottoCount;
    }

    public WinningLotto getWinningLotto(){
        return getWinningLottoManual();
    }

    public WinningLottoManual getWinningLottoManual(){
        ArrayList<Number> inputNumberList = getNumberList();
        Lotto lotto = new Lotto(inputNumberList);
        Number bonusNumber = getBonusNumber();
        return new WinningLottoManual(lotto, bonusNumber);
    }

    public ArrayList<Number> getNumberList(){
        System.out.println();
        System.out.println(LAST_WEEK_WINNING_NUMBER_MESSAGE);
        String str = sc.nextLine();
        String[] strList = str.replace(SPACE,BLANK).split(COMMA);
        int[] nums = Arrays.stream(strList)
                .mapToInt(Integer::parseInt).toArray();

        ArrayList<Number> numberList = new ArrayList<>();
        for(int num : nums){
            numberList.add(new Number(num));
        }
        return numberList;
    }

    public Number getBonusNumber(){
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        return new Number(bonusNumber);
    }
}
