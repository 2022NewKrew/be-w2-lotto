package util;

import domain.LottoInfo;

public class Message {
	public static final String INPUT_LOTTO_PURCHASE_MONEY = "구매금액을 입력해 주세요.";

	public static final String INPUT_CUSTOM_LOTTO_PURCHASE_AMOUNT = "수동으로 구매할 로또 수를 입력해 주세요.";

	public static final String INPUT_CUSTOM_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

	public static final String PURCHASE_LOTTO_AMOUNT = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";

	public static final String INPUT_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

	public static final String INPUT_BONUS_LOTTO_NUMBER = "보너스 볼을 입력해 주세요.";

	public static final String LOTTO_STATISTICS_RESULT = "당첨 통계";

	public static final String HORIZONTAL_LINE = "---------";

	public static final String PROFIT_RESULT = "총 수익률은 %.2f%% 입니다.";

	public static final String INVALID_LOTTO_AMOUNT = "잘못된 수량입니다.";

	public static final String INVALID_LOTTO_NUMBER_LENGTH = "로또는 " + LottoInfo.PICK + "개의 숫자로 이루어져야 합니다.";

	public static final String INVALID_LOTTO_NUMBER_RANGE =
		"로또의 숫자는 " + LottoInfo.MIN + "과 " + LottoInfo.MAX + "사이의 숫자로 이루어져야 합니다.";

	public static final String DUPLICATE_LOTTO_NUMBER = "중복된 로또 숫자가 존재합니다.";
}
