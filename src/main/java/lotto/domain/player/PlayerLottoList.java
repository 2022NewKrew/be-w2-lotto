package lotto.domain.player;

import java.util.*;
public class PlayerLottoList {

    private final List<PlayerLotto> lottoList = new ArrayList<>();

    public void purchaseAutoLotto() {
        lottoList.add(new PlayerLotto());
    }

    public void purchaseManualLotto(PlayerLotto manualLotto) {
        lottoList.add(manualLotto);
    }

    public List<PlayerLotto> getPlayerLottoList() {
        return lottoList;
    }
}
