package back.database;

import back.domain.Lotto;
import back.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class RogerSQL {
    private final List<Lotto> lottoList;
    private WinningLotto winningLotto;

    public RogerSQL() {
        this.lottoList = new ArrayList<>();
    }

    public void save(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottoList;
    }

    public void save(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningLotto find() {
        return winningLotto;
    }
}
