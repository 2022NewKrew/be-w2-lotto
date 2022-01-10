package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottosDto {

    private final List<LottoDto> lottoDtos;
    private final int customLottoCount;
    private final int autoLottoCount;

    public LottosDto(List<LottoDto> lottoDtos, int customLottoCount, int autoLottoCount) {
        this.lottoDtos = lottoDtos;
        this.customLottoCount = customLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public static LottosDto LottosToDto(Lottos lottos) {
        final List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            lottoDtos.add(LottoDto.lottoToDto(lotto));
        }
        return new LottosDto(lottoDtos, lottos.getCustomLottoCount(), lottos.getAutoLottoCount());
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }

    public int getCustomLottoCount() {
        return customLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
