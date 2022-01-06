package org.cs.finn.lotto.view;

import org.cs.finn.lotto.domain.LottoWinnings;
import org.cs.finn.lotto.domain.Lottos;
import org.cs.finn.lotto.domain.Money;
import org.cs.finn.lotto.domain.lotto.LottoNumber;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.cs.finn.lotto.util.Checker;
import org.cs.finn.lotto.util.Separator;

import java.util.Objects;
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
        System.out.println("당첨 번호 " + LottoNumbers.SIZE + "개를 " +
                "[" + Separator.DEFAULT_SEPARATOR + "]로 구분해서 중복 없이 입력해 주세요. " +
                "[" + LottoNumber.MIN + " ~ " + LottoNumber.MAX + "]");

        return requestLottoNumbers("",true);
    }

    private LottoNumbers requestLottoNumbers(final String prefix, final boolean insertNewLine) {
        LottoNumbers lottoNumbers = getLottoNumbersFromInput(prefix, insertNewLine);
        while (lottoNumbers.isNone()) {
            System.out.println("유효한 번호 입력의 개수가 " + LottoNumbers.SIZE + "개가 아닙니다.");
            System.out.println("다시 입력해주세요.");
            lottoNumbers = getLottoNumbersFromInput(prefix, insertNewLine);
        }

        return lottoNumbers;
    }

    private LottoNumbers getLottoNumbersFromInput(final String prefix, final boolean insertNewLine) {
        System.out.print(prefix);
        final String[] numbers = Separator.splitString(sc.nextLine().trim());
        if (insertNewLine) {
            System.out.println();
        }

        try {
            return new LottoNumbers(numbers);
        } catch (IllegalArgumentException e) {
            return LottoNumbers.NONE;
        }
    }

    private LottoNumber getBonusNumber(final LottoNumbers lottoNumbers) {
        Objects.requireNonNull(lottoNumbers);
        System.out.println("보너스 번호를 입력해 주세요. [" + LottoNumber.MIN + " ~ " + LottoNumber.MAX + "]");
        System.out.println("당첨 번호에서 입력한 번호들을 제외하고 남은 번호들 중 하나를 입력해주세요.");

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

    public int requestCountOfLottoManual(final Lottos lottos, final Money money) {
        Objects.requireNonNull(lottos);
        Objects.requireNonNull(money);

        System.out.println("수동으로 구매할 Lotto 수를 입력해 주세요. [최대 " + money.maxNumberToBuyLottos() + "개]");
        int count = getCountOfLottoManualFromInput();
        while (money.notEnoughToBuyLottos(count)) {
            System.out.println("최대 구매 가능한 회수 초과, 잘못된 값 또는 음수가 입력되었습니다.");
            System.out.println("다시 입력해주세요.");
            count = getCountOfLottoManualFromInput();
        }

        return count;
    }

    private int getCountOfLottoManualFromInput() {
        try {
            return Integer.parseInt(sc.nextLine().trim(), 10);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            return Integer.MAX_VALUE;
        } finally {
            System.out.println();
        }
    }

    public Money requestBuyLottoManual(final Lottos lottos, final Money money, final int count) {
        Objects.requireNonNull(lottos);
        Objects.requireNonNull(money);
        Checker.checkInt(count, false);

        if (count == 0) {
            return money;
        }
        if (money.notEnoughToBuyLottos(count)) {
            throw new RuntimeException("Not enough money to buy " + count + " lotto(s)!");
        }

        requestBuyLottoManualFromInput(lottos, count);
        return money.buyLottoManual(count);
    }

    private void requestBuyLottoManualFromInput(final Lottos lottos, final int count) {
        System.out.println("수동으로 구매할 Lotto " + count + "개 입력해 주세요.");
        System.out.println("각 Lotto는 번호 "+ LottoNumbers.SIZE + "개를 " +
                "[" + Separator.DEFAULT_SEPARATOR + "]로 구분해서 중복 없이 입력해 주세요. " +
                "[" + LottoNumber.MIN + " ~ " + LottoNumber.MAX + "]");

        for (int i = 0; i < count; i++) {
            lottos.add(requestLottoNumbers((i + 1) + "/" + count + ": ", false));
        }

        System.out.println();
    }
}
