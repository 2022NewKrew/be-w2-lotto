package service;

import domain.lotto.*;

import java.util.*;
import java.util.stream.Collectors;

import static domain.lotto.LottoValidator.*;

public class LottoInputService {

    private static final String INPUT_DELIMITER = ",";

    private final Scanner sc;

    public LottoInputService() {
        this.sc = new Scanner(System.in);
    }

    public LottoGameInfo inputPurchaseParam() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = inputInt();
        validatePositiveNumber(money);

        List<Lotto> manualPurchaseLottoList = inputManualLottoList(money);

        return new LottoGameInfo(money, manualPurchaseLottoList);
    }

    private List<Lotto> inputManualLottoList(int money) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numOfPurchaseManually = inputInt();
        validatePositiveNumber(numOfPurchaseManually);
        validateNumOfPurchaseManually(money, numOfPurchaseManually);
        List<Lotto> manualPurchaseLottoList = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int currentLottoNum = 0; currentLottoNum < numOfPurchaseManually; currentLottoNum++) {
            manualPurchaseLottoList.add(createNewManualLotto());
        }
        return manualPurchaseLottoList;
    }

    private Lotto createNewManualLotto() {
        List<Integer> inputNumbers = inputNumbersToList();
        validateInputNumbers(inputNumbers);
        return LottoGenerator.generateOneLotto(inputNumbers);
    }

    public WinningLotto inputWinningLottoNumbers() {
        List<Integer> inputWinningNumbers;
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        inputWinningNumbers = inputNumbersToList();
        validateInputNumbers(inputWinningNumbers);

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusLottoNumber = inputInt();
        validateBonusLottoNumber(inputWinningNumbers, bonusLottoNumber);

        return LottoGenerator.generateWinningLotto(inputWinningNumbers, bonusLottoNumber);
    }

    private int inputInt() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            throw new IllegalArgumentException("[에러] 반드시 숫자를 입력해야 합니다.");
        }
    }

    private List<Integer> inputNumbersToList() {
        String[] inputStrings = sc.next().split(INPUT_DELIMITER);
        try {
            return Arrays.stream(inputStrings)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[에러] 반드시 숫자를 입력해야 합니다.");
        }
    }

}
