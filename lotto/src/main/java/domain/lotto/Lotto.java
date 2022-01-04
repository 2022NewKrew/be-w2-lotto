package domain.lotto;

import java.util.List;
import utils.LottoUtils;

public class Lotto {

  public static final int LOTTO_COUNT = 6;
  public static final int LOTTO_PRICE = 1000;
  private final List<Integer> holder;

  private Lotto() {
    this.holder = LottoUtils.getRandomNumbers(LOTTO_COUNT);
  }

  private Lotto(List<Integer> holder) {
    this.holder = holder;
  }

  public static Lotto of(List<Integer> holder) {
    return new Lotto(holder);
  }

  public static Lotto ofRandom() {
    return new Lotto();
  }


  public int getMatchCount(Lotto other) {
    int matchCount = 0;
    for (Integer number : holder) {
      matchCount += other.contains(number) ? 1 : 0;
    }
    return matchCount;
  }


  public boolean isBonusMatched(int bonusNumber) {
    return holder.contains(bonusNumber);
  }


  public boolean contains(int number) {
    return holder.contains(number);
  }


  @Override
  public String toString() {
    return holder.toString();
  }
}
