package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputPurchaseAmount(){
        System.out.println("구매금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static ArrayList inputWinningNumber(){
        ArrayList<Integer> lastLottoNumbers;
        List<String> numberLineSplit;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberLine = sc.next();
        numberLineSplit = Arrays.asList(numberLine.split(","));
        try{
            lastLottoNumbers = new ArrayList<Integer>(numberLineSplit.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));
        } catch(NumberFormatException e){
            lastLottoNumbers = new ArrayList<>();
        }
        return lastLottoNumbers;
    }

    public static int inputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }


}
