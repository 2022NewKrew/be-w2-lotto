package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Lotto {
    void createObject();

    static int calculateEqualCount(Lotto userLotto, Lotto pastWinningLotto) {
        int count = 0;
        for (int number : userLotto.getLottoNumbers()) {
            count = pastWinningLotto.getLottoNumbers().contains(number) ? count + 1 : count;
        }
        return count;
    }

    void generateRandomLotto();

    void initialize(String originalLottoString);

    List<Integer> getLottoNumbers();
}
