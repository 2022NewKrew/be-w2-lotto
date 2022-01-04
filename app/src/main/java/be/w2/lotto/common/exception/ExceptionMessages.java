package be.w2.lotto.common.exception;

public class ExceptionMessages {
    public static final String FORBIDDEN_INSTANCE_GENERATION_EXCEPTION = "인스턴스 생성이 금지된 객체에 대한 인스턴스 생성입니다.";
    public static final String PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION = "로또 구매금액은 최소 0 이상 가능합니다.";
    public static final String INVALID_WINNING_NUMBERS_EXCEPTION = "당첨 번호는 6개의 숫자가 필요합니다.";
    public static final String INVALID_NUMBER_RANGE_EXCEPTION = "로또 번호는 1 이상 45 이하입니다.";
    public static final String DIVIDE_BY_ZERO_EXCEPTION = "Divide by zero. 유효하지 않은 purchase amount를 메서드에 전달하였습니다.";
    public static final String WINNING_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION = "로또 번호는 중복일 수 없습니다.";
    public static final String BONUS_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION = "보너스 번호는 당첨 번호와 중복일 수 없습니다.";
}
