package dto;

import java.util.Collections;
import java.util.List;

public class LottosDto {
    private final List<List<Integer>> lottos;

    public LottosDto(List<List<Integer>> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
