package utils;

import java.text.MessageFormat;

public enum Message {

  NULL_PARAMETER("{0} 값이 null 입니다."),
  INVALID_BONUS_NUMBER_RANGE("bonusNumber 값이 로또 범위에 유효하지 않습니다. [입력값 : {0}]"),
  INVALID_BONUS_NUMBER_NON_NUMBER("bonusNumber 값이 제대로 된 숫자 형식이 아닙니다. [입력값 : {0}]");

  private final String pattern;

  Message(String pattern) {
    this.pattern = pattern;
  }


  public static String format(Message message, Object...args) {
    if(message == NULL_PARAMETER) {
      args[0] = args[0].getClass().getName();
    }

    return MessageFormat.format(message.pattern, args);
  }

}
