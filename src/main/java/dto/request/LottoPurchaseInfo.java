package dto.request;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import domain.Lotto;
import util.IOUtils;

public class LottoPurchaseInfo {
	private final int purchaseMoney;
	private final List<Lotto> customLottoList;

	public LottoPurchaseInfo(int purchaseMoney, List<Lotto> customLottoList) {
		this.purchaseMoney = purchaseMoney;
		this.customLottoList = customLottoList;
	}

	public LottoPurchaseInfo(String inputMoney, String manualNumberStr) {
		this.purchaseMoney = getPurchaseMoney(inputMoney);
		this.customLottoList = getCustomLottoList(manualNumberStr);
	}

	public int getPurchaseMoney() {
		return purchaseMoney;
	}

	public List<Lotto> getCustomLottoList() {
		return customLottoList;
	}

	private int getPurchaseMoney(String inputMoney) {
		return Integer.parseInt(inputMoney);
	}

	private List<Lotto> getCustomLottoList(String manualNumberStr) {
		String[] manualNumberArr = manualNumberStr.split("\r?\n");

		List<Lotto> customLottoList = new ArrayList<>();

		for (String manualNumber : manualNumberArr) {
			customLottoList.add(
				new Lotto(
					IOUtils.stringTokenizerToIntegerList(new StringTokenizer(manualNumber, ",")
					)
				)
			);
		}

		return customLottoList;
	}
}
