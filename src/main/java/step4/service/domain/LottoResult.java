package step4.service.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoResult {
    FIRST(7, 2000000000, "6개 일치 (2000000000원) - "),
    SECOND(6, 1500000, "5개 일치, 보너스 볼 일치 (30000000원) - "),
    THIRD(5, 1500000, "5개 일치 (1500000원) - "),
    FOURTH(4, 50000, "4개 일치 (50000원) - "),
    FIFTH(3, 5000, "3개 일치 (5000원) - "),
    NONE(0, 0, "2개 이하 일치 (0원) - ");

    private final int score;
    private final int prize;
    private final String message;

    private static List<LottoResult> lottoResultList = Arrays.asList(NONE, NONE, NONE, FIFTH, FOURTH, THIRD, SECOND, FIRST);

    LottoResult(int score, int prize, String message) {
        this.score = score;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public int getScore() {
        return score;
    }

    public static LottoResult getResult(int score) {
        return lottoResultList.get(score);
    }
}
