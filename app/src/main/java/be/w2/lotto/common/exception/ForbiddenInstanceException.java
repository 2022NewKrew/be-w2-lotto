package be.w2.lotto.common.exception;

public class ForbiddenInstanceException extends RuntimeException {
    public ForbiddenInstanceException() {
        super(FORBIDDEN_INSTANCE_GENERATION_EXCEPTION);
    }

    private static final String FORBIDDEN_INSTANCE_GENERATION_EXCEPTION = "인스턴스 생성이 금지된 객체에 대한 인스턴스 생성입니다.";
}
