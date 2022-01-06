package carrot.ez.lotto;

import carrot.ez.constants.LottoConstant;
import carrot.ez.entity.LottoEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGenerator {
    private static final List<Integer> lottoNums = IntStream.range(LottoConstant.MIN, LottoConstant.MAX + 1).boxed().collect(Collectors.toList());


    public static List<LottoEntity> generateLotto(long size) {
        List<LottoEntity> autoLottos = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            autoLottos.add(generateLotto());
        }

        return autoLottos;
    }

    public static LottoEntity generateLotto() {
        Collections.shuffle(lottoNums);
        ArrayList<Integer> numbers = new ArrayList<>(lottoNums.subList(0, 6)); // 같은 참조값을 사용하지 않게 하기 위해 deep copy
        Collections.sort(numbers);
        return new LottoEntity(numbers, LotteryDiv.AUTO);
    }

    private LotteryGenerator() {
    }
}
