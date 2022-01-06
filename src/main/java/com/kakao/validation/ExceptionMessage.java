package com.kakao.validation;

public enum ExceptionMessage {
    MONEY("음수값이 입력되었습니다."),
    NUMBER_COUNT("6개의 번호가 입력되지 않았습니다."),
    NUMBER_VALIDATION("1 ~ 45 이외의 번호가 입력되었습니다."),
    NUMBER_OVERLAP("중복된 번호가 입력되었습니다."),
    COUNT_OVERFLOW("최대 구매 갯수를 초과하였습니다.");

    private final String message;

    public String getMessage() { return message; }

    ExceptionMessage(String message) {
        this.message = message;
    }

}
