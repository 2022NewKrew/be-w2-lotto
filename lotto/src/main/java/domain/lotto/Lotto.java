package domain.lotto;

import domain.lottery.WinningLotto;
import domain.statistics.MatchInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 객체. 6가지 숫자를 보관하며, 로또에 관한 기본정보들을 static 으로 보관 객체의 랜덤 생성 및 외부로 부터 주입받아 로또 객체가 생성된다. 위닝 로또와 비교하여
 * 매칭 정보를 반환한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class Lotto {

  private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>(List.of(
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
      11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
      21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
      31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
      41, 42, 43, 44, 45
  ));
  public static final int LOTTO_COUNT = 6;
  public static final int LOTTO_PRICE = 1000;
  private final List<Integer> holder;

  private Lotto() {
    this.holder = generateRandomNumbers(LOTTO_COUNT);
  }


  protected Lotto(List<Integer> holder) {
    this.holder = holder;
  }


  public static Lotto of(List<Integer> holder) {
    return new Lotto(holder);
  }


  public static Lotto ofRandom() {
    return new Lotto();
  }


  public MatchInfo compareWith(WinningLotto winningLotto) {
    int matchCount = getMatchCount(winningLotto);
    boolean isBonusMatched = isBonusMatched(winningLotto.getBonusNumber());
    return MatchInfo.of(matchCount, isBonusMatched);
  }


  private int getMatchCount(Lotto other) {
    int matchCount = 0;
    for (Integer number : holder) {
      matchCount += other.contains(number) ? 1 : 0;
    }
    return matchCount;
  }


  private boolean isBonusMatched(int bonusNumber) {
    return holder.contains(bonusNumber);
  }


  public boolean contains(int number) {
    return holder.contains(number);
  }


  @Override
  public String toString() {
    return holder.toString();
  }


  private List<Integer> generateRandomNumbers(int size) {
    Collections.shuffle(LOTTO_NUMBERS);
    return LOTTO_NUMBERS.stream()
        .limit(size)
        .sorted()
        .collect(Collectors.toList());
  }

}
