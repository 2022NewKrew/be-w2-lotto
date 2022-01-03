package step1.domain.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step1.utils.CommonConstants.*;

public class Lottos {
    private static final List<Integer> AVAIL_LOTTO_NUMS = IntStream
            .range(START_LOTTO_NUM, END_LOTTO_NUM)
            .boxed().collect(Collectors.toList());

    private final List<Lotto> lottos;

    public Lottos(int lottosQuantity) {
        this.lottos = new ArrayList<>();
        makeLottoNumbers(lottosQuantity);
    }

    private void makeLottoNumbers(int lottosQuantity) {
        for (int i = 0; i < lottosQuantity; i++) {
            Collections.shuffle(AVAIL_LOTTO_NUMS, new Random(System.nanoTime()));
            List<Integer> chosenLottoNumbers = new ArrayList<>(AVAIL_LOTTO_NUMS.subList(0, RESULT_LOTTO_NUM));
            Collections.sort(chosenLottoNumbers);
            lottos.add(new Lotto(chosenLottoNumbers));
        }
    }

    public Lotto lottoOf(int i) {
        return lottos.get(i);
    }

    public int sizeOf() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
        }

        return sb.toString();
    }
}
