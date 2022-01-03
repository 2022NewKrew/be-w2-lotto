package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoConfig {
	private static final int MIN = 1;
	private static final int MAX = 45;
	private static final int PRICE = 1000;

	public static final int PICK = 7;

	public static final List<Integer> allLottoNumberList =
		IntStream.rangeClosed(MIN, MAX)
			.mapToObj(number -> Integer.valueOf(number))
			.collect(Collectors.toList());

	public static int getAmountOfLotto(int money) {
		return money / PRICE;
	}
}
