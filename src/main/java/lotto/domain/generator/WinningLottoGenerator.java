package lotto.domain.generator;

import lotto.configure.LottoConfigure;
import lotto.domain.Lotto;
import lotto.domain.WiningLotto;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoGenerator extends LottoManualGenerator implements LottoGenerator {

    private int bonusNumber;

    public WinningLottoGenerator(@NotNull List<Integer> userNumbers, int bonusNumber) {
        super(userNumbers);
        this.bonusNumber = bonusNumber;
    }

    @Override
    public Lotto generateLotto() {
        return new WiningLotto(super.getUserNumbers(), bonusNumber);
    }

}
