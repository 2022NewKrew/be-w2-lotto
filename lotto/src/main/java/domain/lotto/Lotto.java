package domain.lotto;

import java.util.List;

public class Lotto {

  public static final int LOTTO_COUNT = 6;
  private final List<Integer> holder;

  private Lotto() {
    this.holder = LottoUtils.getRandomNumbers(LOTTO_COUNT);
  }

  private Lotto(List<Integer> holder) {
    this.holder = holder;
  }

  public static Lotto ofRandom() {
    return new Lotto();
  }


  @Override
  public String toString() {
    return holder.toString();
  }
}
