package domain.statistics;

/**
 * Lotto 와 WinningLottery 간 비교 후 생긴 매칭 정보
 *
 * @author leo.jung
 * @since 1.0
 */
public class MatchInfo {

  private final int matchCount;
  private final boolean isBonusMatched;

  private MatchInfo(int matchCount, boolean isBonusMatched) {
    this.matchCount = matchCount;
    this.isBonusMatched = isBonusMatched;
  }


  public static MatchInfo of(int matchCount, boolean isBonusMatched) {
    return new MatchInfo(matchCount, isBonusMatched);
  }


  public int getMatchCount() {
    return matchCount;
  }

  public boolean isBonusMatched() {
    return isBonusMatched;
  }
}
