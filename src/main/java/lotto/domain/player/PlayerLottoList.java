package lotto.domain.player;

import java.util.*;
public class PlayerLottoList {

    private final List<PlayerLotto> lottoList = new ArrayList<>();

    public PlayerLottoList() {
    }

    public void addPlayerLotto(PlayerLotto playerLotto){
        lottoList.add(playerLotto);
    }

    public List<PlayerLotto> getPlayerLottoList() {
        return lottoList;
    }
}
