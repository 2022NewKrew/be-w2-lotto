package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerLottoList {

    private final List<Lotto> lottoList = new ArrayList<>();

    public void purchaseLotto() {
        lottoList.add(new Lotto());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
