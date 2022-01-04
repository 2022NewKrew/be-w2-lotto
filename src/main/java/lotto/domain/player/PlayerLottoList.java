package lotto.domain.player;

import java.util.*;
public class PlayerLottoList {

    private final List<PlayerLotto> lottoList = new ArrayList<>();

    public void purchaseLotto() {
        lottoList.add(new PlayerLotto());
    }

    public List<PlayerLotto> getPlayerLottoList() {
        return lottoList;
    }
}
