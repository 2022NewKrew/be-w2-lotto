package domain.lotto;

import static utils.ErrorMessage.INVALID_LOTTO_DUPLICATION;
import static utils.ErrorMessage.INVALID_LOTTO_NUMBERS;
import static utils.ErrorMessage.NULL_PARAMETER;
import static utils.ErrorMessage.format;

import domain.lottery.WinningLotto;
import domain.statistics.MatchInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 로또 객체. 6가지 숫자를 보관하며, 로또에 관한 기본정보들을 static 으로 보관 객체의 랜덤 생성 및 외부로 부터 주입받아 로또 객체가 생성된다. 위닝 로또와 비교하여
 * 매칭 정보를 반환한다. 로또의 생성 방식 변수 추가 - 자동생성되었는지, 수동생성되었는지. holder 의 자료구조를 treeSet 으로 수정.
 *
 * @author leo.jung
 * @since 1.2
 */
public class Lotto implements Iterable<LottoNumber> {

  private static final List<LottoNumber> NUMBERS_POOL = new ArrayList<>() {{
    for (int num = LottoNumber.MIN_NUMBER; num <= LottoNumber.MAX_NUMBER; num++) {
      add(LottoNumber.of(num));
    }
  }};
  public static final int TOTAL_NUMBER = 6;
  public static final int PRICE = 1000;
  protected final Set<LottoNumber> holder;
  private final boolean randomGenerated;

  private Lotto() {
    this.holder = new TreeSet<>(generateRandomNumbers(TOTAL_NUMBER));
    this.randomGenerated = true;
  }


  protected Lotto(List<LottoNumber> holder) {
    Objects.requireNonNull(holder, format(NULL_PARAMETER, holder));
    this.holder = new TreeSet<>(holder);
    this.randomGenerated = false;
    validCheck(holder);
  }


  public static void validCheck(List<LottoNumber> holder) {
    if (holder.size() != TOTAL_NUMBER) {
      throw new IllegalArgumentException(
          format(INVALID_LOTTO_NUMBERS, holder));
    }
    if (hasDuplicatedNumber(holder)) {
      throw new IllegalArgumentException(
          format(INVALID_LOTTO_DUPLICATION, holder));
    }
  }


  public static boolean hasDuplicatedNumber(List<LottoNumber> holder) {
    int originSize = holder.size();
    int distinctSize = (int) holder.stream()
        .distinct()
        .count();
    return originSize != distinctSize;
  }


  public static Lotto of(List<LottoNumber> holder) {
    return new Lotto(holder);
  }


  public static Lotto ofRandom() {
    return new Lotto();
  }


  public MatchInfo compareWith(WinningLotto winningLotto) {
    int matchCount = getMatchCount(winningLotto);
    boolean isBonusMatched = hasNumber(winningLotto.getBonusNumber());
    return MatchInfo.of(matchCount, isBonusMatched);
  }


  public boolean isRandomGenerated() {
    return randomGenerated;
  }


  public boolean isManualGenerated() {
    return !randomGenerated;
  }


  private int getMatchCount(Lotto other) {
    return (int) holder.stream()
        .filter(other::hasNumber)
        .count();
  }


  public boolean hasNumber(LottoNumber bonusNumber) {
    return holder.contains(bonusNumber);
  }


  @Override
  public String toString() {
    return holder.toString();
  }


  private List<LottoNumber> generateRandomNumbers(int size) {
    Collections.shuffle(NUMBERS_POOL);
    return NUMBERS_POOL.stream()
        .limit(size)
        .collect(Collectors.toList());
  }


  public Stream<LottoNumber> stream() {
    return holder.stream();
  }


  @Override
  public Iterator<LottoNumber> iterator() {
    return holder.iterator();
  }

  @Override
  public void forEach(Consumer<? super LottoNumber> action) {
    holder.forEach(action);
  }

}
