package utils;

import java.text.MessageFormat;

public enum ErrorMessage {

  NULL_PARAMETER("{0} 값이 null 입니다."),
  INVALID_BONUS_NUMBER_RANGE("bonusNumber 값이 로또 범위에 유효하지 않습니다. [입력값 : {0}]"),
  INVALID_BONUS_NUMBER_NON_NUMBER("bonusNumber 값이 제대로 된 숫자 형식이 아닙니다. [입력값 : {0}]"),
  INVALID_BONUS_NUMBER_DUPLICATION("bonusNumber 값은 로또 값과 중복될 수 없습니다. [bonusNumber : {0} / 로또 번호 : {1}]"),
  INVALID_LOTTO_NUMBERS("로또 생성 시 필요한 Integer 의 개수는 {0} 입니다. [입력 인자 : {1}]"),
  INVALID_LOTTO_DUPLICATION("로또 의 각 숫자는 중복되어서는 안됩니다. [입력 인자 : {0}]"),
  INVALID_MATCH_COUNT_NEGATIVE("matchCount 는 음수가 될 수 없습니다. [입력값 : {0}]"),
  INVALID_OVER_BUY_LIMIT("구매 가능한 수량 초과. [구매 가능 개수 : {0} / 입력 구매 개수 : {1}]"),
  INVALID_INPUT_NUMBER_NEGATIVE("입력 값은 0 이상의 정수이어야 합니다. [입력 값 : {0}]");

  private final String pattern;

  ErrorMessage(String pattern) {
    this.pattern = pattern;
  }


  public static String format(ErrorMessage errorMessage, Object...args) {
    if(errorMessage == NULL_PARAMETER) {
      args[0] = args[0].getClass().getName();
    }

    return MessageFormat.format(errorMessage.pattern, args);
  }

}
