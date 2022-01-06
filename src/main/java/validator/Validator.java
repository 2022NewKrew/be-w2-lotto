package validator;

import constant.Constant;
import exception.IllegalInputException;

import java.util.List;

public class Validator {
    public static void checkBonusBallNumberValidity(Integer bonusBallNumber, List<Integer> winningSequence) {
        checkBallNumberValidity(bonusBallNumber);
        checkContainment(bonusBallNumber, winningSequence);
    }

    public static void checkBallNumberValidity(int input) {
        checkPositiveInt(input);
        checkRange(Constant.LOTTO_START_NUM, Constant.LOTTO_END_NUM, input);
    }

    public static void checkWholeNumber(int input) {
        if (input < 0)
            throw new IllegalInputException("0 이상의 정수를 입력하세요.");
    }

    public static void checkPositiveInt(int input) {
        if (input <= 0)
            throw new IllegalInputException("0 보다 큰 정수를 입력하세요.");
    }

    private static void checkRange(int start, int end, int input) {
        if (input < start || input > end)
            throw new IllegalInputException("범위 안의 정수를 입력하세요 (" + start + "~" + end + ")");
    }

    private static <T> void checkContainment(T element, List<? extends T> list) {
        if (list.contains(element))
            throw new IllegalInputException("중복된 값입니다.");
    }

    public static void checkManualCount(int input, int budget) {
        checkWholeNumber(input);
        if (input * Constant.LOTTO_COST > budget)
            throw new IllegalInputException("비용이 초과되었습니다.");
    }

    public static void checkLottoSequence(List<Integer> lottoSequence) {
        if (lottoSequence.size() != Constant.LOTTO_SIZE)
            throw new IllegalInputException(Constant.LOTTO_SIZE + "개의 수를 입력하세요.");
        if (lottoSequence.stream().distinct().count() != Constant.LOTTO_SIZE)
            throw new IllegalInputException("중복된 값이 있습니다.");
    }
}
