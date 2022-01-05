package domain;

import view.Guide;
import view.LottoInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoSimulator {
    public static final int PRICE = 1000;
    private final LottoInterface lottoInterface;
    private final LottoAutoGenerator lottoAutoGenerator;
    private final LottoManualGenerator lottoManualGenerator;

    public LottoSimulator(LottoInterface lottoInterface) {
        this.lottoInterface = lottoInterface;
        this.lottoAutoGenerator = new LottoAutoGenerator();
        this.lottoManualGenerator = new LottoManualGenerator(lottoInterface);
    }

    public void run() {
        lottoInterface.printGuide(Guide.INPUT_PRICE);
        final int cost = lottoInterface.inputNumber();
        final int amountLotto = cost / PRICE;

        lottoInterface.printGuide(Guide.INPUT_MANUAL_LOTTO_NUM);
        final int amountManualLotto = lottoInterface.inputNumber();

        lottoInterface.printGuide(Guide.INPUT_MANUAL_NUMS);
        final List<Lotto> manualLottos = buyLotto(lottoManualGenerator, amountManualLotto);
        final List<Lotto> autoLottos = buyLotto(lottoAutoGenerator, amountLotto - amountManualLotto);
        final List<Lotto> lottos = mergeLottos(manualLottos, autoLottos);

        lottoInterface.printBoughtAmount(manualLottos.size(), autoLottos.size());
        lottoInterface.printLottos(lottos);

        final List<Result> results = checkLottoResult(lottos, lottoInterface.inputWinningNumbers());
        lottoInterface.printResults(results);
        lottoInterface.printEarningRate(cost, results);
    }

    private List<Lotto> buyLotto(LottoGenerable lottoGenerator, int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Lotto> mergeLottos(List<Lotto> a, List<Lotto> b) {
        return Stream.concat(a.stream(), b.stream()).collect(Collectors.toUnmodifiableList());
    }

    private List<Result> checkLottoResult(List<Lotto> lottos, Winning winning) {
        List<Prize> prizes = lottos.stream()
                .map(lotto -> Prize.getLottoPrize(lotto, winning))
                .collect(Collectors.toUnmodifiableList());

        return Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NONE)
                .map(prize -> new Result(prize, Collections.frequency(prizes, prize)))
                .collect(Collectors.toUnmodifiableList());
    }
}











