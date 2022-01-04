package service;

import domain.lotto.Lotto;
import domain.lotto.LottoGameInfo;
import domain.lotto.LottoGenerator;

import java.util.Scanner;

import static util.LottoConst.LOTTO_NUMBERS;

public class LottoInputService {

    private static final String INPUT_DELIMITER = ",";

    private final Scanner sc;

    public LottoInputService() {
        this.sc = new Scanner(System.in);
    }

    public LottoGameInfo inputPurchaseParam() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();

        return new LottoGameInfo(money);
    }

    public Lotto inputWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputLottoNumbers = sc.next().split(INPUT_DELIMITER);

        return LottoGenerator.generateOneLotto(inputLottoNumbers);
    }

    public int inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusLottoNumber = sc.nextInt();

        validateBonusLottoNumber(bonusLottoNumber);
        return bonusLottoNumber;
    }

    private void validateBonusLottoNumber(int bonusNumber) {
        if (!LOTTO_NUMBERS.contains(bonusNumber)) {
            throw new IllegalArgumentException("[에러] 보너스 번호는 1 ~ 45 사이의 숫자를 입력해야 합니다.");
        }
    }

}
