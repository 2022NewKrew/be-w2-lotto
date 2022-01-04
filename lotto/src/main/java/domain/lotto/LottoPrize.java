package domain.lotto;

import domain.statistics.MatchInfo;
import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {

  RANK_5TH(3, 5000, false),
  RANK_4TH(4, 50000, false),
  RANK_3RD(5, 1500000, false),
  RANK_2ND(5, 30000000, true),
  RANK_1ST(6, 2000000000, false);

  private int matchCount;
  private int reward;
  private boolean needBonusNumber;

  LottoPrize(int matchCount, int reward, boolean needBonusNumber) {
    this.matchCount = matchCount;
    this.reward = reward;
    this.needBonusNumber = needBonusNumber;
  }

  //FIXME: get 할 시 Stream 열어서 찾지말고, unmodifiableMap 으로 사전에 static 으로 보관하는 방식 활용해 볼 것.
  // https://pjh3749.tistory.com/279
  private static Optional<LottoPrize> get(int matchCount, boolean isBonusMatched) {
    return Arrays.stream(LottoPrize.values())
        .filter(lottoPrize -> lottoPrize.matchCount == matchCount)
        .filter(lottoPrize -> {
          if(matchCount == 5) {
            return lottoPrize.needBonusNumber == isBonusMatched;
          }
          return true;
        })
        .findAny();
  }


  public static Optional<LottoPrize> get(MatchInfo matchInfo) {
    return get(matchInfo.getMatchCount(), matchInfo.isBonusMatched());
  }


  public int getMatchCount() {
    return matchCount;
  }

  public void setMatchCount(int matchCount) {
    this.matchCount = matchCount;
  }

  public int getReward() {
    return reward;
  }

  public void setReward(int reward) {
    this.reward = reward;
  }

  public boolean isNeedBonusNumber() {
    return needBonusNumber;
  }

  public void setNeedBonusNumber(boolean needBonusNumber) {
    this.needBonusNumber = needBonusNumber;
  }

  @Override
  public String toString() {
    if(needBonusNumber) {
      return matchCount + "개 일, 보너스 볼 일치(" + reward + "원)";
    }
    return matchCount + "개 일치 (" + reward + "원)";
  }

}
