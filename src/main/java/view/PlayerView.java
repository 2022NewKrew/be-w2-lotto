package view;

import domain.Lotto;
import domain.Player;

import java.util.List;

public class PlayerView {
    private final Player player;
    public PlayerView(Player player) {
        this.player = player;
    }
    public void PrintPlayerLottoList()
    {
        System.out.println(player.getLottoList().size() + "개를 구매했습니다.");
        List<Lotto> lottoList = player.getLottoList();
        for(Lotto lotto : lottoList)
        {
            LottoView.printLotto(lotto);
        }
    }
}
