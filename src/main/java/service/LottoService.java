package service;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoPrize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LottoService {
    private int buyPrice;
    private int size;
    private final List<Lotto> lottos;

    private Lotto winningLotto;
    private LottoNumber bonusBall;
    private List<Integer> winningResult;
    private long profit;

    public LottoService() {
        lottos = new ArrayList<Lotto>();
    }

    public void registerAutoLottos(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("로또 개수가 유효하지 않습니다.");
        }
        lottos.addAll(Stream.generate(Lotto::new).limit(n).collect(Collectors.toList()));
        updateData();
    }

    public void registerManualLotto(List<String> number) {
        lottos.add(new Lotto(number));
        updateData();
    }

    private void updateData() {
        this.size = lottos.size();
        this.buyPrice = lottos.size() * 1000;
    }

    public void registerWinningLotto(List<String> number) {
        winningLotto = new Lotto(number);
    }

    public void registerBonusBall(int number) {
        bonusBall = new LottoNumber(number);
        if (winningLotto.isNumberExist(bonusBall)) {
            throw new IllegalArgumentException("보너스 번호가 중복됩니다.");
        }
        winningResult = calculateWinningResult(winningLotto);
        profit = IntStream.rangeClosed(1, 5).mapToLong(rank -> (long) winningResult.get(rank) * LottoPrize.getMoneyWithRanking(rank)).sum();
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

    public List<Integer> getWinningResult() { return winningResult; }

    public List<Lotto> getLottos() { return lottos; }

    public int getBuyPrice() { return buyPrice; }

    public long getProfit() { return profit; }

    public int getSize() { return size; }
}
