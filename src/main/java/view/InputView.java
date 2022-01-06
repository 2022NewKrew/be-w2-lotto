package view;

import model.Lotto;
import model.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_GREATER_ZERO = "0이상의 정수를 입력해주세요.";
    private static final String INPUT_MANUAL_ERROR = "수동 구매는 0개 이상 총 구매수 이하여야합니다.";
    private static final String INPUT_SIX_NUMBERS = "반드시 6개의 숫자가 들어가야 합니다.";
    private static final String INPUT_RANGE_1_TO_45 ="로또 숫자는 1이상 45이하여야합니다.";

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        if(purchaseAmount < 0){
            throw new IllegalArgumentException(INPUT_GREATER_ZERO);
        }
        return purchaseAmount;
    }

    public static int readManualLottoCount(int lottoCount){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        if(manualLottoCount < 0 || manualLottoCount > lottoCount){
            throw new IllegalArgumentException(INPUT_MANUAL_ERROR);
        }
        return manualLottoCount;
    }

    public static List<List<Integer>> readManualLottoNumbers(int manualLottoCount){

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(readLottoNumbers());
        }
        return manualLottos;
    }

    public static List<Integer> readLastWeeksWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return readLottoNumbers();
    }

    private static List<Integer> readLottoNumbers(){
        List<String> numbers = Arrays.asList(scanner.nextLine().split(","));

        List<Integer> newNumbers = new ArrayList<>();
        for (String number : numbers) {
            newNumbers.add(Integer.parseInt(number));
        }

        return newNumbers;
    }

    public static int readBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(INPUT_RANGE_1_TO_45);
        }
        return bonusNumber;
    }
}