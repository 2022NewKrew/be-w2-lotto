package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int TOTAL_SIZE = 6;
    private static final int BONUS_BALL_NUMBER = 5;
    private static final int BONUS_MATCH_COUNT = 7;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String SPLIT_DELIMITER = ",";

    private int bonusBall;
    private List<Integer> lottoNumbers;

    private WinningLotto(int bonusBall, List<Integer> lottoNumbers) {
        this.bonusBall = bonusBall;
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static WinningLotto of(int bonusBall, String winningLottoNumbers) {
        List<Integer> lottoNumbers = Arrays.stream(winningLottoNumbers.split(SPLIT_DELIMITER))
                .map(number -> Integer.parseInt(number.replaceAll("\\s", "")))
                .collect(Collectors.toList());

        validateLotto(lottoNumbers);
        validateBonusBall(bonusBall, lottoNumbers);

        Collections.sort(lottoNumbers);
        return new WinningLotto(bonusBall, lottoNumbers);
    }

    private static void validateLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().count() != TOTAL_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_SIZE.getMessage());
        }

        if (lottoNumbers.stream().distinct().count() < TOTAL_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_NUMBER.getMessage());
        }

        if (lottoNumbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    private static void validateBonusBall(int bonusBall, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_BONUS_BALL.getMessage());
        }
    }

    public int getMatchNumberCount(List<Integer> purchaseLottoNumbers) {
        int matchNumberCount = (int) purchaseLottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();

        return (matchNumberCount == BONUS_BALL_NUMBER && purchaseLottoNumbers.contains(bonusBall)) ?
                BONUS_MATCH_COUNT : matchNumberCount;
    }
}
