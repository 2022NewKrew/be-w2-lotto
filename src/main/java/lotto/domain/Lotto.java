package lotto.domain;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.LOTTO_MAX_NUM;

public class Lotto {
    ArrayList<Integer> lottoNumbers;
    Random random;

    public Lotto() {
        lottoNumbers = new ArrayList<Integer>();
        random = new Random();
    }

    public void generateRandomLotto() {
        lottoNumbers.clear();
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            lottoNumbers.add(random.nextInt(LOTTO_MAX_NUM));
        }
    }

    @Override
    public java.lang.String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }

    public void initialize(String originalLottoString) {
        ArrayList<String> lottoStrings = new ArrayList<String>(Arrays.asList(originalLottoString.replace(" ", "").split(",")));
//        System.out.println(lottoStrings);
        for (String lottoString : lottoStrings) {
            lottoNumbers.add(Integer.parseInt(lottoString));
        }
    }
}
