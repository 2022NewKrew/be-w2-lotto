package domain.statistics;

import domain.lottery.WinningLottery;
import domain.lotto.Lotto;
import domain.lotto.LottoPrize;
import domain.lotto.LottoWallet;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * 통계 담당
 * 구매한 로또와 WinningLottery 를 기반으로
 * LottoPrize 당 당첨 로또를 보관하며, 당첨 금액과 수익률 통계를 낸다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class Statistics {

  private final Map<LottoPrize, List<Lotto>> winningLotteryHolder;
  private final int buyAmount;

  private Statistics(WinningLottery winningLottery, LottoWallet wallet) {
    this.winningLotteryHolder = new EnumMap<>(LottoPrize.class);
    this.buyAmount = calculateBuyAmount(wallet);
    setupHolder();
    setupMatchMap(winningLottery, wallet);
  }


  private void setupHolder() {
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      winningLotteryHolder.put(lottoPrize, new ArrayList<>());
    }
  }


  private int calculateBuyAmount(LottoWallet wallet) {
    return wallet.size() * Lotto.LOTTO_PRICE;
  }


  public static Statistics of(WinningLottery winningLottery, LottoWallet wallet) {
    return new Statistics(winningLottery, wallet);
  }


  private void setupMatchMap(WinningLottery winningLottery, LottoWallet wallet) {
    for(Lotto candidateLotto : wallet) {
      MatchInfo matchInfo = candidateLotto.compareWith(winningLottery);
      addLottoIfMatched(matchInfo, candidateLotto);
    }
  }


  private void addLottoIfMatched(MatchInfo matchInfo, Lotto lotto) {
    LottoPrize.of(matchInfo)
        .ifPresent(lottoPrize -> {
          addLottoIntoHolder(lottoPrize, lotto);
        });
  }


  private void addLottoIntoHolder(LottoPrize lottoPrize, Lotto lotto) {
    List<Lotto> matchLottoList = winningLotteryHolder.get(lottoPrize);
    matchLottoList.add(lotto);
  }


  private int getProfitRate() {
    return (int)((double) getProfitAmount() / buyAmount * 100 - 100);
  }


  private int getProfitAmount() {
    return winningLotteryHolder.entrySet().stream()
        .map(matcherIntegerEntry -> {
          int reward = matcherIntegerEntry.getKey().getReward();
          int count = matcherIntegerEntry.getValue().size();
          return reward * count;
        })
        .reduce(0, Integer::sum);
  }


  @Override
  public String toString() {
    return "당첨 통계" + '\n'
        + "---------" + '\n'
        + stringifyMatchMap()
        + "총 수익률은 " + getProfitRate() + "%입니다." + '\n';
  }


  private String stringifyMatchMap() {
    StringBuilder sb = new StringBuilder();
    winningLotteryHolder.forEach((lottoPrize, count) -> {
      sb.append(stringify(lottoPrize));
    });
    return sb.toString();
  }


  private String stringify(LottoPrize lottoPrize) {
    List<Lotto> matchLottoList = winningLotteryHolder.getOrDefault(lottoPrize, new ArrayList<>());
    int count = matchLottoList.size();
    return lottoPrize + " - " + count + "개\n";
  }

}
