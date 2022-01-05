package domain;

import dto.LottoDTO;
import dto.LottosDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void addLottos(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }

    public long size() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottosDTO exportLottosDTO() {
        List<LottoDTO> lottos = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            lottos.add(lotto.exportLottoDTO());
        }
        return new LottosDTO(lottos);
    }
}
