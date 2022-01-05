package view;

import domain.Const;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        try{
            int purchaseAmount = getInteger(scanner.nextLine());
            validateMinPurchase(purchaseAmount);
            return purchaseAmount;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }
    public static int inputManualAmount(int numOfPurchasedLotto) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try{
            int manualAmount = getInteger(scanner.nextLine());
            validateMaxPurchase(manualAmount, numOfPurchasedLotto);
            validateMinus(manualAmount);
            return manualAmount;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return inputManualAmount(numOfPurchasedLotto);
        }
    }
    public static int inputBonusNum(){
        System.out.println("보너스 볼을 입력해 주세요.");
        try{
            int bonusNum = getInteger(scanner.nextLine());
            validateLottoNum(bonusNum);
            return bonusNum;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNums();
    }

    public static List<Integer> inputLottoNums() {
        List<String> lottoNumInput = Arrays.asList(scanner.nextLine().split(","));
        try{
            validateLottoNumEmpty(lottoNumInput);   // 빈 칸이 입력된 경우(쉼표 2개 연속)
            validateLottoNumNotInt(lottoNumInput);  // 정수가 아닌 수가 입력된 경우
            validateLottoNumList(lottoNumInput);    // 입력된 숫자가 로또의 범위(1~45)를 벗어나는 경우
            validateLottoLen(lottoNumInput);        // 번호가 6개가 아닌 경우
            return lottoNumInput.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return inputLottoNums();
        }
    }

    private static void validateLottoLen(List<String> lottoNumInput) throws Exception {
        if (lottoNumInput.size() != 6)
            throw new Exception("숫자는 6개를 입력해야 합니다.");
    }
    private static void validateLottoNumList(List<String> lottoNumInput) throws Exception {
        for (String num : lottoNumInput)
            validateLottoNum(Integer.parseInt(num));
    }
    private static void validateLottoNumNotInt(List<String> lottoNumInput) {
        for(String num : lottoNumInput)
            getInteger(num);
    }
    private static void validateLottoNumEmpty(List<String> lottoNumInput) throws Exception {
        if(lottoNumInput.contains(null))
            throw new Exception("빈 칸이 입력되면 안 됩니다.");
    }
    private static int getInteger(String s) throws NumberFormatException {
        try{
            return Integer.parseInt(s);
        }
        catch(Exception e){
            throw new NumberFormatException("구입금액은 정수로 입력해 주세요.");
        }
    }
    private static void validateMinPurchase(int price) throws Exception {
        if(price < Const.PRICE_OF_LOTTO)
            throw new Exception();
    }
    private static void validateMaxPurchase(int manualAmount, int numOfPurchasedLotto) throws Exception {
        if(manualAmount > numOfPurchasedLotto)
            throw new Exception("수동으로 구매할 수 있는 장수를 초과했습니다.");
    }
    private static void validateMinus(int num) throws Exception {
        if (num < 0)
            throw new Exception("양수를 입력해 주세요.");
    }
    private static void validateLottoNum(int bonusNum) throws Exception {
        if (!Const.LOTTO_NUMBERS.contains(bonusNum))
            throw new Exception("로또 번호 범위를 벗어나선 안 됩니다.");
    }

}
