package dto;

import domain.lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoCreateResponse {

    private final List<String> lottos;
    private final int lottosSize;

    public LottoCreateResponse(List<Lotto> lottos) {
        this.lottos = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
        this.lottosSize = lottos.size();
    }

    public List<String> getLottos() {
        return lottos;
    }

    public int getLottosSize() {
        return lottosSize;
    }
}
