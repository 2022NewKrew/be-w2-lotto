package domain.lotto;

import static utils.ErrorMessage.INVALID_BONUS_NUMBER_NON_NUMBER;
import static utils.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;
import static utils.ErrorMessage.NULL_PARAMETER;
import static utils.ErrorMessage.format;

import java.util.Objects;

/**
 * 보너스 넘버 객체. Integer 를 래핑 및 Integer 범위가 로또 범위인지 유효성 체크를 한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  private final Integer lottoNumber;

  private LottoNumber(Integer lottoNumber) {
    this.lottoNumber = Objects.requireNonNull(lottoNumber, format(NULL_PARAMETER, lottoNumber));
    if (isNonLottoNumber(lottoNumber)) {
      throw new IllegalArgumentException(
          format(INVALID_BONUS_NUMBER_RANGE, lottoNumber));
    }
  }


  public static LottoNumber of(Integer bonusNumber) {
    return new LottoNumber(bonusNumber);
  }


  public static LottoNumber of(String strBonusNumber) {
    int parsedNumber;
    try {
      parsedNumber = Integer.parseInt(strBonusNumber);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          format(INVALID_BONUS_NUMBER_NON_NUMBER, strBonusNumber));
    }
    return new LottoNumber(parsedNumber);
  }


  public boolean isNonLottoNumber(int number) {
    return number > MAX_NUMBER || number < MIN_NUMBER;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return Objects.equals(lottoNumber, that.lottoNumber);
  }


  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }


  @Override
  public int compareTo(LottoNumber o) {
    return Integer.compare(lottoNumber, o.lottoNumber);
  }


  @Override
  public String toString() {
    return String.valueOf(lottoNumber);
  }

}
