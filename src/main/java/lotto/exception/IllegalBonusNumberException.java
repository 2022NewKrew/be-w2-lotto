package lotto.exception;

import static lotto.domain.LottoConstant.*;

public class IllegalBonusNumberException extends Exception {

    public IllegalBonusNumberException(String message, Throwable cause) {
        super(message + " 발생 예외: " + cause);
    }

    public IllegalBonusNumberException(String message, int number) {
        super(message + number + "는 " + START + " ~ " + END + " 사이의 값이 아닙니다.");
    }
}
