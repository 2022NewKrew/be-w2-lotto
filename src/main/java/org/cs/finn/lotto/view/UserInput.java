package org.cs.finn.lotto.view;

import org.cs.finn.lotto.domain.LottoWinnings;
import org.cs.finn.lotto.domain.Money;
import org.cs.finn.lotto.domain.lotto.LottoNumber;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.cs.finn.lotto.util.Separator;

import java.util.Scanner;

public class UserInput {

    private final Scanner sc = new Scanner(System.in);

    public Money requestMoney() {
        System.out.println("Lotto 구매에 사용할 금액을 입력해 주세요.");
        final Money money = getMoneyFromInput();
        System.out.println();

        return money;
    }

    private Money getMoneyFromInput() {
        try {
            return new Money(sc.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값 또는 음수 입력으로 " + Money.DEFAULT + "으로 시작합니다.");
        }

        return Money.DEFAULT;
    }

    public LottoWinnings requestLottoWinnings() {
        final LottoNumbers lottoNumbers = getLottoNumbers();
        final LottoNumber bonusNumber = getBonusNumber(lottoNumbers);

        return new LottoWinnings(lottoNumbers, bonusNumber);
    }

    private LottoNumbers getLottoNumbers() {
        System.out.println("보너스 번호를 제외한 당첨 번호 " + LottoNumbers.SIZE + "개를 " +
                "[" + Separator.DEFAULT_SEPARATOR + "]로 구분해서 중복 없이 입력해 주세요. " +
                "[" + LottoNumber.MIN + " ~ " + LottoNumber.MAX + "]");

        LottoNumbers lottoNumbers = getLottoNumbersFromInput();
        while (lottoNumbers.isNone()) {
            System.out.println("유효한 번호 입력의 개수가 " + LottoNumbers.SIZE + "개가 아닙니다.");
            System.out.println("다시 입력해주세요.");
            lottoNumbers = getLottoNumbersFromInput();
        }

        return lottoNumbers;
    }

    private LottoNumbers getLottoNumbersFromInput() {
        final String[] numbers = Separator.splitString(sc.nextLine().trim());
        try {
            return new LottoNumbers(numbers);
        } catch (IllegalArgumentException e) {
            return LottoNumbers.NONE;
        } finally {
            System.out.println();
        }
    }

    private LottoNumber getBonusNumber(final LottoNumbers lottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요. [" + LottoNumber.MIN + " ~ " + LottoNumber.MAX + "]");
        System.out.println("당첨 번호에서 입력한 번호와 중복된 번호를 입력하면 안됩니다.");

        LottoNumber lottoNumber = getBonusNumberFromInput();
        while (lottoNumbers.contains(lottoNumber) || lottoNumber.isNone()) {
            System.out.println("잘못된 번호, 당첨 번호에 입력한 번호 또는 허용 숫자 범위를 벗어난 번호가 입력되었습니다.");
            System.out.println("다시 입력해주세요.");
            lottoNumber = getBonusNumberFromInput();
        }

        return lottoNumber;
    }

    private LottoNumber getBonusNumberFromInput() {
        try {
            return new LottoNumber(sc.nextLine().trim());
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            return LottoNumber.NONE;
        } finally {
            System.out.println();
        }
    }

}
