package service;

import domain.lotto.Lotto;
import domain.lotto.LottoGameInfo;
import domain.lotto.LottoGenerator;
import domain.lotto.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

import static util.LottoConst.*;

public class LottoInputService {

    private static final String INPUT_DELIMITER = ",";

    private final Scanner sc;

    public LottoInputService() {
        this.sc = new Scanner(System.in);
    }

    private int inputInt() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[에러] 반드시 숫자를 입력해야 합니다.");
        }
    }

    private List<Integer> inputNumbersToList() {
        String[] strings = sc.next().split(INPUT_DELIMITER);
        return Arrays.stream(strings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public LottoGameInfo inputPurchaseParam() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = inputInt();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numOfPurchaseManually = inputInt();
        validateNumOfPurchaseManually(money, numOfPurchaseManually);
        List<Lotto> manualPurchaseLottoList = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int currentLottoNum = 0; currentLottoNum < numOfPurchaseManually; currentLottoNum++) {
            manualPurchaseLottoList.add(createNewManualLotto());
        }

        return new LottoGameInfo(money, manualPurchaseLottoList);
    }

    private void validateNumOfPurchaseManually(int money, int numOfPurchaseManually) {
        if (money < numOfPurchaseManually * LOTTO_PRICE) {
            throw new IllegalArgumentException("[에러] 입력한 금액보다 많은 로또를 구매할 수 없습니다.");
        }
    }

    private Lotto createNewManualLotto() {
        try {
            List<Integer> inputNumbers = inputNumbersToList();
            return LottoGenerator.generateOneLotto(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[에러] 반드시 숫자를 입력해야 합니다.");
        }
    }

    public WinningLotto inputWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> inputWinningNumbers = inputNumbersToList();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusLottoNumber = inputInt();
        validateBonusLottoNumber(bonusLottoNumber);

        return LottoGenerator.generateWinningLotto(inputWinningNumbers, bonusLottoNumber);
    }

    private void validateBonusLottoNumber(int bonusNumber) {
        if (!LOTTO_NUMBERS.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    String.format("[에러] 보너스 번호는 %s ~ %s 사이의 숫자를 입력해야 합니다.",
                            MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            );
        }
    }

}
