package back.generator;

import back.domain.Prize;

import java.util.Arrays;

public class PrizeGenerator {
    public static Prize generate(int correctAmount, boolean isBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getCorrectAmount() == correctAmount && checkBonus(prize, correctAmount, isBonus))
                .findFirst()
                .orElse(null);
    }

    private static boolean checkBonus(Prize prize, int correctAmount, boolean isBonus) {
        if (correctAmount != Prize.SECOND_BONUS.getCorrectAmount())
            return true;
        return prize.getIsBonus() == isBonus;
    }
}
