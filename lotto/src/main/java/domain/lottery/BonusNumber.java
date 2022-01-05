package domain.lottery;

import domain.lotto.Lotto;
import java.util.Optional;

public class BonusNumber {

  private final Integer bonusNumber;

  private BonusNumber(Integer bonusNumber) {
    this.bonusNumber = Optional.ofNullable(bonusNumber)
        .orElseThrow(() -> new IllegalArgumentException("bonusNumber 값이 null 입니다."));

    if(bonusNumber > Lotto.MAX_NUMBER || bonusNumber < Lotto.MIN_NUMBER) {
      throw new IllegalArgumentException("bonusNumber 값이 로또 범위에 유효하지 않습니다. [입력값 : " + bonusNumber + "]");
    }
  }


  public static BonusNumber of(Integer bonusNumber) {
    return new BonusNumber(bonusNumber);
  }


  public static BonusNumber of(String strBonusNumber) {
    int parsedNumber;
    try{
      parsedNumber = Integer.parseInt(strBonusNumber);
    }catch(NumberFormatException e) {
      throw new IllegalArgumentException("bonusNumber 값이 제대로 된 숫자 형식이 아닙니다. [입력값 : " + strBonusNumber + "]");
    }
    return new BonusNumber(parsedNumber);
  }


  public Integer getInteger() {
    return bonusNumber;
  }


}
