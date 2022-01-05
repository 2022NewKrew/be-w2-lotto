package lotto.constant;

import java.util.Arrays;

import static lotto.constant.Constants.INVALID_INPUT_ERROR_MESSAGE;

public enum WinningType {

    FIRST( 7, "6개 일치",             2000000000),
    SECOND(6, "5개 일치, 보너스볼 일치", 30000000),
    THIRD( 5, "5개 일치",             1500000),
    FOURTH(4, "4개 일치",             50000),
    FIFTH( 3, "3개 일치",             5000);

    WinningType(int matchedNum, String message, int prizeMoney) {
        this.matchedNum = matchedNum;
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    private final int matchedNum;
    private final String message;
    private final int prizeMoney;

    public static WinningType findType(int matchedNum) {
        return Arrays.stream(values())
                .filter(type -> type.matchedNum == matchedNum)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE));
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
