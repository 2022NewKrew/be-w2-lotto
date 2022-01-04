package lotto.domain;

import java.util.*;
public class PlayerLottoList {

    private final List<Lotto> lottoList = new ArrayList<>();

    public void purchaseLotto() {
        lottoList.add(new Lotto());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
