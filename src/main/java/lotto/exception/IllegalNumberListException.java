package lotto.exception;

import java.util.List;

import static lotto.domain.LottoConstant.*;

public class IllegalNumberListException extends Exception {

    public IllegalNumberListException(String message) {
        super(message);
    }
    public IllegalNumberListException(String message, Throwable cause) {
        super(message + " 발생 예외: " + cause);
    }

    public IllegalNumberListException(String message, List<Integer> numberList) {
        super(message + numberList.toString() + "는 " + START + " ~ " + END + " 사이의 값이 아닙니다.");
    }
}
