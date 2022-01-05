package View;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import domain.Lotto;
import domain.WinningLotto;
import dto.request.LottoPurchaseInfo;
import dto.response.LottoPurchaseAmount;
import util.IOUtils;
import util.Message;

public class LottoInputView {
	public static LottoPurchaseInfo getPurchaseMoney() {
		System.out.println(Message.INPUT_LOTTO_PURCHASE_MONEY);
		int purchaseMoney = Integer.parseInt(IOUtils.SCANNER.nextLine());
		System.out.println();

		System.out.println(Message.INPUT_CUSTOM_LOTTO_PURCHASE_AMOUNT);
		int customAmount = Integer.parseInt(IOUtils.SCANNER.nextLine());
		System.out.println();

		return new LottoPurchaseInfo(purchaseMoney, customAmount);
	}

	public static List<Lotto> getCustomLotto(LottoPurchaseAmount lottoPurchaseAmount) {
		int customAmount = lottoPurchaseAmount.getCustomAmount();
		List<Lotto> lottoList = new ArrayList<>();

		if (customAmount < 0) {
			return lottoList;
		}

		System.out.println(Message.INPUT_CUSTOM_LOTTO_NUMBER);
		for (int number = 0; number < customAmount; number++) {
			lottoList.add(new Lotto(getLottoNumber()));
		}
		System.out.println();

		return lottoList;
	}

	public static WinningLotto getWinningLotto() {
		System.out.println(Message.INPUT_WINNING_LOTTO_NUMBER);
		List<Integer> lottoNumberList = getLottoNumber();
		System.out.println();

		System.out.println(Message.INPUT_BONUS_LOTTO_NUMBER);
		int bonusNumber = Integer.parseInt(IOUtils.SCANNER.nextLine());

		return new WinningLotto(lottoNumberList, bonusNumber);
	}

	private static List<Integer> getLottoNumber() {
		return IOUtils.stringTokenizerToIntegerList(
			new StringTokenizer(IOUtils.SCANNER.nextLine(), ",")
		);
	}
}
