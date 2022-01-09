package lotto.domain.generator;

import lotto.configure.LottoConfigure;
import lotto.domain.Lotto;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class LottoManualGenerator implements LottoGenerator {

    private final List<Integer> userNumbers;

    public LottoManualGenerator(@NotNull List<Integer> userNumbers) {
        if (userNumbers.size() != LottoConfigure.NUMBERS_SIZE) throw new ExceptionInInitializerError();
        this.userNumbers = userNumbers.stream().collect(Collectors.toList());
    }

    @Override
    public Lotto generateLotto() {
        return new Lotto(userNumbers);
    }

}
