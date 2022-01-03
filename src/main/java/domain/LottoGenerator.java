package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
	public static Lotto generateLotto() {
		List<Integer> allLottoNumberList = new ArrayList<>(LottoConfig.allLottoNumberList);

		Collections.shuffle(allLottoNumberList);

		return new Lotto(
			allLottoNumberList.stream()
				.limit(LottoConfig.PICK)
				.sorted()
				.collect(Collectors.toList())
		);
	}
}
