package lotto.step1.util;

import lotto.step1.exception.CustomFormatException;

@FunctionalInterface
public interface Validator<T> {

    void validate(T value);

    Validator<Integer> FROM_1_TO_45_VALIDATOR = value -> {
        if (value < 1 || value > 45)
            throw new CustomFormatException("1에서 45의 숫자만 입력해주세요");
    };

    Validator EMPTY_VALIDATOR = value -> {
    };

    Validator<Integer> GREATER_THAN_1000 = value -> {
        if (value < 1000) {
            throw new CustomFormatException("1000보다 큰 금액을 입력해주세요");
        }
    };
}
