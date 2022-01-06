package lotto.step1.exception;

public class ConsoleInputCountExceededException extends LottoGameException{
    public ConsoleInputCountExceededException() {
        super("입력 횟수가 초과 되었습니다.");
    }
}
