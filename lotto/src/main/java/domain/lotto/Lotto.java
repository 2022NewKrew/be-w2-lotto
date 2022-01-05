package domain.lotto;

import domain.lottery.BonusNumber;
import domain.lottery.WinningLotto;
import domain.statistics.MatchInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 로또 객체. 6가지 숫자를 보관하며, 로또에 관한 기본정보들을 static 으로 보관 객체의 랜덤 생성 및 외부로 부터 주입받아 로또 객체가 생성된다. 위닝 로또와 비교하여
 * 매칭 정보를 반환한다. 로또의 생성 방식 변수 추가 - 자동생성되었는지, 수동생성되었는지.
 *
 * @author leo.jung
 * @since 1.1
 */
public class Lotto {

  private static final List<Integer> NUMBERS_POOL = new ArrayList<>(){{
    for(int num = MIN_NUMBER; num <= MAX_NUMBER; num++) {
      add(num);
    }
  }};
  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  public static final int TOTAL_NUMBER = 6;
  public static final int PRICE = 1000;
  protected final List<Integer> holder;
  private final boolean randomGenerated;

  private Lotto() {
    this.holder = generateRandomNumbers(TOTAL_NUMBER);
    this.randomGenerated = true;
  }


  protected Lotto(List<Integer> holder) {
    this.holder = Objects.requireNonNull(holder, "holder 값이 null 입니다.");
    this.randomGenerated = false;
    validCheck(holder);
  }


  public static void validCheck(List<Integer> holder) {
    if(holder.size() != TOTAL_NUMBER) {
      throw new IllegalArgumentException("로또 생성 시 필요한 Integer 의 개수는 " + TOTAL_NUMBER + " 입니다. [입력 인자 : " + holder + "]");
    }
    if(hasNonLottoNumber(holder)) {
      throw new IllegalArgumentException("로또 생성 시 범위를 벗어난 숫자가 있습니다. [입력 인자 : " + holder + "]");
    }
    if(hasDuplicatedNumber(holder)) {
      throw new IllegalArgumentException("로또 의 각 숫자는 중복되어서는 안됩니다. [입력 인자 : " + holder + "]");
    }
  }


  public static boolean hasNonLottoNumber(List<Integer> holder) {
    return holder.stream()
        .anyMatch(Lotto::isNonLottoNumber);
  }


  public static boolean hasDuplicatedNumber(List<Integer> holder) {
    int originSize = holder.size();
    int distinctSize = (int) holder.stream()
        .distinct()
        .count();
    return originSize != distinctSize;
  }


  public static boolean isNonLottoNumber(int number) {
    return number > Lotto.MAX_NUMBER || number < Lotto.MIN_NUMBER;
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


  public boolean isRandomGenerated() {
    return randomGenerated;
  }


  public boolean isManualGenerated() {
    return !randomGenerated;
  }


  private int getMatchCount(Lotto other) {
    int matchCount = 0;
    for (Integer number : holder) {
      matchCount += other.contains(number) ? 1 : 0;
    }
    return matchCount;
  }


  protected boolean isBonusMatched(BonusNumber bonusNumber) {
    return holder.contains(bonusNumber.getInteger());
  }


  public boolean contains(int number) {
    return holder.contains(number);
  }


  @Override
  public String toString() {
    return holder.toString();
  }


  private List<Integer> generateRandomNumbers(int size) {
    Collections.shuffle(NUMBERS_POOL);
    return NUMBERS_POOL.stream()
        .limit(size)
        .sorted()
        .collect(Collectors.toList());
  }

}
