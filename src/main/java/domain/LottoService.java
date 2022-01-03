package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LottoService {
    private static final double COST_PER_LOTTO = 1000.0;

    private final List<Lotto> lottos = new ArrayList<>();
    private final Integer money;

    public LottoService(Integer money) {
        this.money = Optional.ofNullable(money).orElseThrow(IllegalArgumentException::new);
        validateMoney();

        generateLottos();
    }

    private void validateMoney(){
        if(money<0) throw new IllegalArgumentException();
    }

    private void generateLottos(){
        Stream.generate(LottoNumberGenerator::generate)
                .limit(calcLottoCount())
                .map(Lotto::new)
                .forEach(lottos::add);
    }

    private int calcLottoCount(){
        return (int) Math.floor(money / COST_PER_LOTTO);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
