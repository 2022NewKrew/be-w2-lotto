package util;

import java.util.List;

@FunctionalInterface
public interface Validator<T> {

    void validate(T value);

    Validator<Integer> INTEGER_WITHIN_1_AND_45 = value -> {
        if (value < 1 || value > 45)
            throw new RuntimeException("입력값은 1과 45 사이의 숫자이여야 합니다.");
    };

    Validator<Integer> INTEGER_GREATER_THAN_OR_EQUAL_TO_1000 = value -> {
        if (value < 1000)
            throw new RuntimeException("입력값은 1000보다 크거나 같은 숫자이여야 합니다.");
    };

    Validator<Integer> INTEGER_NOT_NEGATIVE_NUMBER = value -> {
        if (value < 0)
            throw new RuntimeException("입력값은 0 혹은 양수이여야 합니다.");
    };

    Validator<Integer> INTEGER_GREATER_THAN_OR_EQUAL_TO_1 = value -> {
        if (value < 1)
            throw new RuntimeException("입력값은 1보다 크거나 같은 숫자이여야 합니다.");
    };

    Validator<List<Integer>> LIST_SIZE_EQUAL_TO_6 = value -> {
        if (value.size() != 6)
            throw new RuntimeException("입력값의 갯수가 6개이여야 합니다.");
    };

    Validator<Void> EMPTY_VALIDATOR = value -> {};
}
