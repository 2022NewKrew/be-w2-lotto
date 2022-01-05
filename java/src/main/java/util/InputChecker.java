package util;

import domain.Lotto;

import java.util.List;

public class InputChecker {

    public void checkMoney(Lotto lotto, int money) throws IllegalArgumentException {
        if (money < lotto.getTicketPrice()) {
            throw new IllegalArgumentException(String.format("금액은 %d원 이상이어야 합니다.", lotto.getTicketPrice()));
        }

        if (money % lotto.getTicketPrice() != 0) {
            throw new IllegalArgumentException(String.format("금액은 %d원 단위로 입력해야합니다.", lotto.getTicketPrice()));
        }
    }

    public void checkManualTicketCount(Lotto lotto,
                                       int money,
                                       int manualTicketCount) throws IllegalArgumentException {
        if (money / lotto.getTicketPrice() < manualTicketCount) {
            throw new IllegalArgumentException("구매할 수 있는 최대 로또 수를 초과하였습니다.");
        }
    }

    public void checkTicketNumber(Lotto lotto,
                                  List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != lotto.getNumberCount()) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복된 번호를 허용하지 않습니다.");
        }

        if (numbers.stream().anyMatch(num -> num < lotto.getMinNumber() || num > lotto.getMaxNumber())) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
        }
    }

    public void checkBonusNumber(List<Integer> winningNumber,
                                 int bonusNumber) throws IllegalArgumentException {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
