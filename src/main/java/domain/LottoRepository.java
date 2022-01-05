package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private List<List<Integer>> list = new ArrayList<>();
    private int autoQuantity;
    private int manualQuantity;

    public LottoRepository(int autoQuantity, int manualQuantity) {
        this.autoQuantity = autoQuantity;
        this.manualQuantity = manualQuantity;
        checkEmptyList();
        auto();
        manual();
    }

    private void auto() {
        for (int i = 0; i < autoQuantity; i++) {
            Lotto lotto = new Lotto();
            list.add(lotto.autoPick());
        }
    }

    private void manual() {
        for (int i = 0; i < manualQuantity; i++) {
            Lotto lotto = new Lotto();
            list.add(lotto.manuallyPick());
        }
    }

    public List<List<Integer>> getList() {
        return list;
    }

    private void checkEmptyList(){
        if(manualQuantity + autoQuantity == 0){
            throw new IllegalArgumentException("로또를 구매하지 않았습니다. 수익률 계산이 불가합니다");
        }
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
