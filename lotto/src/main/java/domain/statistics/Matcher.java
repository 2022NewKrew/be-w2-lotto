package domain.statistics;

import java.util.Objects;

public class Matcher {

  private final int matchCount;
  private final int reward;

  private Matcher(int matchCount, int reward) {
    this.matchCount = matchCount;
    this.reward = reward;
  }


  public static Matcher of(int matchCount, int reward) {
    return new Matcher(matchCount, reward);
  }


  public int getReward() {
    return reward;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Matcher matcher = (Matcher) o;
    return reward == matcher.reward && matchCount == matcher.matchCount;
  }


  @Override
  public int hashCode() {
    return Objects.hash(reward, matchCount);
  }


  @Override
  public String toString() {
    return matchCount + "개 일치 (" + reward + "원)";
  }
}
