package lotto.step1.exception;

public class NotFoundEntityException extends LottoGameException {
    public NotFoundEntityException() {
        super("해당하는 ID의 로또 정보를 찾을 수 없습니다.");
    }
}
