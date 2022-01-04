package domain.statistics;

import domain.lotto.Lotto;
import domain.lotto.LottoWallet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

  private static final Map<Integer, Integer> amountMap = Map.of(
      3, 5000,
      4, 50000,
      5, 1500000,
      6, 2000000000
  );
  private final Map<Matcher, List<Lotto>> matchMap;
  private final int buyAmount;

  private Statistics(Lotto winningLotto, LottoWallet wallet) {
    this.matchMap = new HashMap<>();
    this.buyAmount = calculateBuyAmount(wallet);
    setupMatchMap(winningLotto, wallet);
  }

  private int calculateBuyAmount(LottoWallet wallet) {
    return wallet.size() * Lotto.LOTTO_PRICE;
  }

  public static Statistics of(Lotto winningLotto, LottoWallet wallet) {
    return new Statistics(winningLotto, wallet);
  }


  private void setupMatchMap(Lotto winningLotto, LottoWallet wallet) {
    for(Lotto candidateLotto : wallet) {
      int matchCount = candidateLotto.getMatchCount(winningLotto);
      addMatchMap(matchCount, candidateLotto);
    }
  }


  private void addMatchMap(int matchCount, Lotto lotto) {
    Matcher matcher = getMatcher(matchCount);
    if(!matchMap.containsKey(matcher)) {
      matchMap.put(matcher, new ArrayList<>());
    }
    List<Lotto> matchLottoList = matchMap.get(matcher);
    matchLottoList.add(lotto);
  }


  private int getProfitRate() {
    return (int)((double) getProfitAmount() / buyAmount * 100 - 100);
  }


  private int getProfitAmount() {
    return matchMap.entrySet().stream()
        .map(matcherIntegerEntry -> {
          int reward = matcherIntegerEntry.getKey().getReward();
          int count = matcherIntegerEntry.getValue().size();
          return reward * count;
        })
        .reduce(0, Integer::sum);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("당첨 통계").append('\n');
    sb.append("---------").append('\n');
    amountMap.forEach((matchCount, v) -> {
      Matcher matcher = getMatcher(matchCount);
      sb.append(toString(matcher)).append('\n');
    });
    sb.append("총 수익률은 ").append(getProfitRate()).append("%입니다.").append('\n');
    return sb.toString();
  }

  public String toString(Matcher matcher) {
    List<Lotto> matchLottoList = matchMap.getOrDefault(matcher, new ArrayList<>());
    int count = matchLottoList.size();
    return matcher + " - " + count + "개";
  }


  private Matcher getMatcher(int matchCount) {
    return Matcher.of(matchCount, amountMap.getOrDefault(matchCount, 0));
  }

}
