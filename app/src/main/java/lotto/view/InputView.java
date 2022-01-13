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

    public static int inputManualGame(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static ArrayList inputWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberLine = sc.next();

        return parseNumberLine(numberLine);
    }

    public static ArrayList inputManualNumber(int manualGame){
        ArrayList<ArrayList<Integer>> manualNumbers = new ArrayList<>();
        String numberLine;
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int game = 0; game < manualGame; game++){
            numberLine = sc.next();
            manualNumbers.add(parseNumberLine(numberLine));
        }
        return manualNumbers;
    }

    public static int inputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    private static ArrayList parseNumberLine(String numberLine){
        ArrayList<Integer> lastLottoNumbers;
        List<String> numberLineSplit;

        numberLineSplit = Arrays.asList(numberLine.split(","));
        lastLottoNumbers = new ArrayList<Integer>(numberLineSplit.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));
        return lastLottoNumbers;
    }
}
