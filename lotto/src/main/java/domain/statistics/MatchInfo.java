package domain.statistics;

import domain.lottery.LotteryMachine;
import domain.lottery.WinningLottery;
import domain.lotto.Lotto;

public class MatchInfo {

  private final int matchCount;
  private final boolean isBonusMatched;

  private MatchInfo(int matchCount, boolean isBonusMatched) {
    this.matchCount = matchCount;
    this.isBonusMatched = isBonusMatched;
  }

  public static MatchInfo of(WinningLottery winningLottery, Lotto lotto) {
    return new MatchInfo(
      lotto.getMatchCount(winningLottery.getCurrentWinningLotto()),
      lotto.isBonusMatched(winningLottery.getBonusNumber())
    );
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean isBonusMatched() {
    return isBonusMatched;
  }
}
