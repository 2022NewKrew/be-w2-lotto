package View;

import java.util.List;
import java.util.StringTokenizer;

import domain.WinningLotto;
import util.IOUtils;
import util.Message;

public class LottoInputView {
	public static int getPurchaseMoney() {
		System.out.println(Message.INPUT_LOTTO_PURCHASE_AMOUNT);
		int purchaseMoney = Integer.parseInt(IOUtils.SCANNER.nextLine());

		return purchaseMoney;
	}

	public static WinningLotto getWinningLotto() {
		System.out.println(Message.INPUT_WINNING_LOTTO_NUMBER);
		List<Integer> lottoNumberList = IOUtils.stringTokenizerToIntegerList(
			new StringTokenizer(IOUtils.SCANNER.nextLine(), ",")
		);
		System.out.println();

		System.out.println(Message.INPUT_BONUS_LOTTO_NUMBER);
		int bonusNumber = Integer.parseInt(IOUtils.SCANNER.nextLine());

		return new WinningLotto(lottoNumberList, bonusNumber);
	}
}
