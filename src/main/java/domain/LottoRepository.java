package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private List<List<Integer>> list = new ArrayList<>();
    private int quantity;

    public LottoRepository(int quantity) {
        this.quantity = quantity;
        lottoPick();
    }

    private void lottoPick() {
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto();
            list.add(lotto.pick());
        }

    }

    public List<List<Integer>> getList() {
        return list;
    }

    @Override
    public String toString() {
        String res = "";
        for (List lotto : list) {
            res += lotto;
            res += "\n";
        }
        return res;
    }
}
