package generator;

import constant.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSequenceGenerator {
    public static List<Integer> generate() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(Constant.LOTTO_START_NUM, Constant.LOTTO_END_NUM).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);

        List<Integer> generatedLottoNumbers = new ArrayList<>(lottoNumbers.subList(0, Constant.LOTTO_SIZE));
        Collections.sort(generatedLottoNumbers);

        return generatedLottoNumbers;
    }
}
