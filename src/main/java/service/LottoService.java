package service;

import domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoService {
    public static final int[] WINNING_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private int buyPrice;
    private int size;
    private List<Lotto> lottos;

    private Lotto winningLotto;
    private List<Integer> winningResult;
    private long profit;

    public void buyLottos(int buyPrice) {
        this.size = buyPrice / 1000;
        this.buyPrice = size * 1000;
        lottos = Stream.generate(Lotto::new).limit(size).collect(Collectors.toList());
    }

    public void registerWinningLotto(String number) {
        winningLotto = new Lotto(number);
        winningResult = calculateWinningResult(winningLotto);
        profit = IntStream.rangeClosed(0, 6).mapToLong(idx -> winningResult.get(idx) * WINNING_MONEY[idx]).sum();
    }

    private List<Integer> calculateWinningResult(Lotto winning) {
        int[] ret = new int[7];
        for (Lotto lotto : lottos) {
            ret[lotto.getSameNumber(winning)]++;
        }
        return Arrays.stream(ret).boxed().collect(Collectors.toList());
    }

    public List<Integer> getWinningResult() {
        return winningResult;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public long getProfit() {
        return profit;
    }

    public int getSize() {
        return size;
    }
}
