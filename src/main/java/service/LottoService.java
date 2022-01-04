package service;

import domain.Lotto;
import domain.LottoPrize;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoService {
    public static final List<Integer> INIT_LOTTO = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    private int buyPrice;
    private int size;
    private List<Lotto> lottos;

    private Lotto winningLotto;
    private int bonusBall;
    private List<Integer> winningResult;
    private long profit;

    public void buyLottos(int buyPrice) {
        if (buyPrice < 1000) {
            throw new IllegalArgumentException("금액이 유효하지 않습니다.");
        }
        this.size = buyPrice / 1000;
        this.buyPrice = size * 1000;
        lottos = Stream.generate(Lotto::new).limit(size).collect(Collectors.toList());
    }

    public void registerWinningLotto(String number) {
        winningLotto = new Lotto(number);
    }

    public void registerBonusBall(int number) {
        if (winningLotto.isNumberExist(number)) {
            throw new IllegalArgumentException("보너스 번호가 중복됩니다.");
        }
        bonusBall = number;
        winningResult = calculateWinningResult(winningLotto);
        profit = IntStream.rangeClosed(1, 5).mapToLong(idx -> winningResult.get(idx) * LottoPrize.PRICES[idx]).sum();
    }

    private List<Integer> calculateWinningResult(Lotto winning) {
        int[] ret = new int[7];
        for (Lotto lotto : lottos) {
            ret[LottoPrize.valueOf(lotto.getSameNumber(winning),
                            lotto.isNumberExist(bonusBall))
                    .getRanking()]++;

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
