package carrot.ez.dto.response;

import java.util.List;

public class LottosDto {

    private final Long id;
    private final List<LottoDto> lottos;
    private final long lottosSize;

    public LottosDto(Long id, List<LottoDto> lottos) {
        this.id = id;
        this.lottos = lottos;
        this.lottosSize = lottos.size();
    }

    public Long getId() {
        return id;
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }

    public long getLottosSize() {
        return lottosSize;
    }
}
