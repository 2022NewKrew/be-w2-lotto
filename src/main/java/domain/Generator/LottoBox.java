package domain.Generator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBox {
    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_NUM_MIN = 1;
    private List<Integer> lottoList = new ArrayList<>();

    private LottoBox() {
        for (int i = LOTTO_NUM_MIN; i <= LOTTO_NUM_MAX; i++) {
            lottoList.add(i);
        }
        lottoList = Collections.unmodifiableList(lottoList);
    }

    private static class InnerInstanceClass {
        private static final LottoBox instance = new LottoBox();
    }

    public static LottoBox getInstance() {
        return InnerInstanceClass.instance;
    }

    public List<Integer> getCopiedLottoList() {
        return new ArrayList<>(lottoList);
    }
}
