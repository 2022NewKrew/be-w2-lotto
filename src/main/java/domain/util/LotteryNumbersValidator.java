package domain.util;

import java.util.HashSet;
import java.util.List;

import static domain.util.LotteryConfigs.*;

public class LotteryNumbersValidator {
    public static void validate(List<Integer> lotteryNumbers, int bonusBall) {
        validate(lotteryNumbers);
        validateDomain(bonusBall);
        validateNonRepetitionForBonusBall(lotteryNumbers, bonusBall);
    }

    public static void validate(List<Integer> lotteryNumbers) {
        validateLength(lotteryNumbers);
        validateDomain(lotteryNumbers);
        validateNonRepetition(lotteryNumbers);
    }

    private static void validateLength(List<Integer> lotteryNumbers) {
        if (lotteryNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 번호 " + lotteryNumbers + "는 " + NUMBERS_LENGTH + "자리가 아닙니다.");
        }
    }

    private static void validateNonRepetitionForBonusBall(List<Integer> resultLotteryNumbers, int bonusBall) {
        if (resultLotteryNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼 " + bonusBall + "은 당첨 번호 " + resultLotteryNumbers + "에 포함되면 안 됩니다.");
        }
    }

    private static void validateNonRepetition(List<Integer> lotteryNumbers) {
        if (!lotteryNumbers.stream().sequential().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException("로또 번호 " + lotteryNumbers + "에 중복이 있습니다.");
        }
    }

    private static void validateDomain(List<Integer> lotteryNumbers) {
        lotteryNumbers.forEach(LotteryNumbersValidator::validateDomain);
    }

    private static void validateDomain(int lotteryNumber) {
        if (!NUMBERS_DOMAIN.contains(lotteryNumber)) {
            // NUMBERS_DOMAIN이 연속을 가정한 에러 메시지
            throw new IllegalArgumentException("번호 " + lotteryNumber + " 는 로또 번호 범위(" + NUMBER_DOMAIN_START + "~" + NUMBER_DOMAIN_END + ") 밖입니다.");
        }
    }
}
