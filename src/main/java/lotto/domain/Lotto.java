package lotto.domain;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.LOTTO_MAX_NUM;

public class Lotto {
    List<Integer> lottoNumbers;
    Random random;

    public Lotto() {
        lottoNumbers = new ArrayList<Integer>();
        random = new Random();
    }

    public static int calculateEqualCount(Lotto userLotto, Lotto pastWinningLotto) {
        int count = 0;
        for (int number : userLotto.getLottoNumbers()) {
            count = pastWinningLotto.getLottoNumbers().contains(number) ? count + 1 : count;
        }
        return count;
    }

    public void generateRandomLotto() {
        lottoNumbers.clear();
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            lottoNumbers.add(random.nextInt(LOTTO_MAX_NUM));
        }
    }

    @Override
    public java.lang.String toString() {
        return lottoNumbers.toString();
    }

    public void initialize(String originalLottoString) {
        List<String> lottoStrings = new ArrayList<String>(Arrays.asList(originalLottoString.replace(" ", "").split(",")));
//        System.out.println(lottoStrings);
        for (String lottoString : lottoStrings) {
            lottoNumbers.add(Integer.parseInt(lottoString));
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
