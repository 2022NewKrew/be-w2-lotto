package domain.lotto;

import domain.statistics.MatchInfo;
import java.util.Arrays;
import java.util.Optional;

/**
 * 로또의 당첨정보 Enum.
 * 당첨 등수에 따른 매칭정보 및 보상을 저장하고 적절한 보상정보를 매핑한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public enum LottoPrize {

  RANK_5TH(3, 5000, false),
  RANK_4TH(4, 50000, false),
  RANK_3RD(5, 1500000, false),
  RANK_2ND(5, 30000000, true),
  RANK_1ST(6, 2000000000, false);

  private final int matchCount;
  private final int reward;
  private final boolean needBonusNumber;

  LottoPrize(int matchCount, int reward, boolean needBonusNumber) {
    this.matchCount = matchCount;
    this.reward = reward;
    this.needBonusNumber = needBonusNumber;
  }

  //FIXME: get 할 시 Stream 열어서 찾지말고, unmodifiableMap 으로 사전에 static 으로 보관하는 방식 활용해 볼 것.
  // https://pjh3749.tistory.com/279
  private static Optional<LottoPrize> of(int matchCount, boolean isBonusMatched) {
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


  public static Optional<LottoPrize> of(MatchInfo matchInfo) {
    return of(matchInfo.getMatchCount(), matchInfo.isBonusMatched());
  }


  public int getMatchCount() {
    return matchCount;
  }

  public int getReward() {
    return reward;
  }

  public boolean isNeedBonusNumber() {
    return needBonusNumber;
  }

  @Override
  public String toString() {
    if(needBonusNumber) {
      return matchCount + "개 일, 보너스 볼 일치(" + reward + "원)";
    }
    return matchCount + "개 일치 (" + reward + "원)";
  }

}
