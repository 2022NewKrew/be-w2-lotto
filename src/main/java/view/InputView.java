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
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = sc.nextInt();
        sc.nextLine();
        return purchaseAmount;
    }

    public int getManualLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
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
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
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
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        return new Number(bonusNumber);
    }
}
