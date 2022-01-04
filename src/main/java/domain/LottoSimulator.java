package domain;

import view.LottoInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSimulator {
    public static final int PRICE = 1000;
    private static final LottoInterface lottoInterface = new LottoInterface();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        int cost = lottoInterface.inputLotto();
        final List<Lotto> lottos = buyLotto(cost / PRICE);
        lottoInterface.printLottos(lottos);
        final List<Result> results = checkLottoResult(lottos, lottoInterface.inputWinningNumbers());
        lottoInterface.printResults(results);
        lottoInterface.printEarningRate(cost, results);
    }

    private List<Lotto> buyLotto(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Result> checkLottoResult(List<Lotto> lottos, Winning winning) {
        List<Prize> prizes = lottos.stream()
                .map(lotto -> lotto.getPrize(winning))
                .collect(Collectors.toUnmodifiableList());

        return Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.BLANK)
                .map(prize -> new Result(prize, Collections.frequency(prizes, prize)))
                .collect(Collectors.toUnmodifiableList());
    }
}











