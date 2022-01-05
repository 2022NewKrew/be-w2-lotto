package domain;

import java.util.List;

import dto.request.LottoPurchaseInfo;
import util.Message;

public class LottoValidator {

	public static void validateLottoPurchaseInfo(LottoPurchaseInfo lottoPurchaseInfo) {
		if (lottoPurchaseInfo.getCustomAmount() * LottoInfo.PRICE > lottoPurchaseInfo.getPurchaseMoney()) {
			throw new IllegalArgumentException(Message.INVALID_LOTTO_AMOUNT);
		}
	}

	public static void validateLottoPurchaseAmount(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(Message.INVALID_LOTTO_AMOUNT);
		}
	}

	public static void validateLottoList(List<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			validateLotto(lotto);
		}
	}

	public static void validateLotto(Lotto lotto) {
		List<Integer> lottoNumberList = lotto.getLottoNumberList();

		checkLottoLength(lottoNumberList.size());

		for (int number : lottoNumberList) {
			checkLottoNumberRange(number);
		}

		long count = lottoNumberList.stream().distinct().count();
		checkDuplicateLottoNumber(count);
	}

	public static void validateWinningLotto(WinningLotto winningLotto) {
		validateLotto(winningLotto);
		checkLottoNumberRange(winningLotto.getBonusNumber());
	}

	private static void checkLottoLength(int size) {
		if (size != LottoInfo.PICK) {
			throw new IllegalArgumentException(Message.INVALID_LOTTO_NUMBER_LENGTH);
		}
	}

	private static void checkLottoNumberRange(int number) {
		if (number < LottoInfo.MIN || number > LottoInfo.MAX) {
			throw new IllegalArgumentException(Message.INVALID_LOTTO_NUMBER_RANGE);
		}
	}

	private static void checkDuplicateLottoNumber(long count) {
		if (count != LottoInfo.PICK) {
			throw new IllegalArgumentException(Message.DUPLICATE_LOTTO_NUMBER);
		}
	}
}
