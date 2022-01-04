package domain;

import java.util.Collections;
import java.util.stream.Collectors;

public class LottoGenerator {
	public static Lotto generateLotto() {
		Collections.shuffle(LottoInfo.allLottoNumberList);

		return new Lotto(
			LottoInfo.allLottoNumberList.stream()
				.limit(LottoInfo.PICK)
				.sorted()
				.collect(Collectors.toList())
		);
	}

	public static int getAmountOfLotto(int purchaseMoney){
		return purchaseMoney / LottoInfo.PRICE;
	}
}
