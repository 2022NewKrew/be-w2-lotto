package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int LOTTO_NUM_MAX = 46;
    private static final List<Integer> lottoBox = new ArrayList<>();
    public static final int LOTTO_NUM_MIN = 1;

    public LottoGenerator(){
        for (int i = LOTTO_NUM_MIN; i < LOTTO_NUM_MAX ; i++) {
            lottoBox.add(i);
        }
    }

    public List<Integer> generateRandomLotto(){
        Collections.shuffle(lottoBox);
        return lottoBox;
    }

}
