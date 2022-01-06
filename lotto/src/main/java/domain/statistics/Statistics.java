package domain.statistics;

import domain.lottery.LottoPrize;
import domain.lottery.WinningLotto;
import domain.lotto.Lotto;
import domain.lotto.LottoWallet;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 통계 담당 구매한 로또와 WinningLottery 를 기반으로 LottoPrize 당 당첨 로또를 보관하며, 당첨 금액과 수익률 통계를 낸다. ==> Statistics
 * 추상 클래스로 변환, Statistics 는 기본적으로 winningLottery 에 대한 판단 및 보관 하는 역할을 하며 이에 대해 구체적인 통계를 내기 위해서는 총 구매
 * 금액 등의 부가적인 항목이 필요해 보인다. 이는 추후 Statistics 를 상속한 구현체가 구현하도록 정의.
 *
 * @author leo.jung
 * @since 1.1
 */
public abstract class Statistics {

  private final Map<LottoPrize, List<Lotto>> winningLottoHolder;

  protected Statistics(WinningLotto winningLotto, LottoWallet wallet) {
    this.winningLottoHolder = new EnumMap<>(LottoPrize.class);
    setupHolder();
    setupWinningLottoHolder(Objects.requireNonNull(winningLotto),
        Objects.requireNonNull(wallet));
  }


  private void setupHolder() {
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      winningLottoHolder.put(lottoPrize, new ArrayList<>());
    }
  }


  private void setupWinningLottoHolder(WinningLotto winningLotto, LottoWallet wallet) {
    for (Lotto candidateLotto : wallet) {
      MatchInfo matchInfo = candidateLotto.compareWith(winningLotto);
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
    List<Lotto> matchLottoList = winningLottoHolder.get(lottoPrize);
    matchLottoList.add(lotto);
  }


  protected int getProfitAmount() {
    return winningLottoHolder.entrySet().stream()
        .map(matcherIntegerEntry -> {
          int reward = matcherIntegerEntry.getKey().getReward();
          int count = matcherIntegerEntry.getValue().size();
          return reward * count;
        })
        .reduce(0, Integer::sum);
  }


  @Override
  public String toString() {
    return "\n당첨 통계" + '\n'
        + "---------" + '\n'
        + stringifyMatchMap();
  }


  private String stringifyMatchMap() {
    StringBuilder sb = new StringBuilder();
    winningLottoHolder.forEach((lottoPrize, count) -> {
      sb.append(stringify(lottoPrize));
    });
    return sb.toString();
  }


  private String stringify(LottoPrize lottoPrize) {
    List<Lotto> matchLottoList = winningLottoHolder.getOrDefault(lottoPrize, new ArrayList<>());
    int count = matchLottoList.size();
    return lottoPrize + " - " + count + "개\n";
  }

}
