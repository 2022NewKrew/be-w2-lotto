package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LottoWinningRank {
	NONE(0, 0),
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000);

	private final int numberOfMatches;
	private final int reward;

	LottoWinningRank(int numberOfMatches, int reward) {
		this.numberOfMatches = numberOfMatches;
		this.reward = reward;
	}

	public int getNumberOfMatches() {
		return numberOfMatches;
	}

	public int getReward() {
		return reward;
	}

	public static LottoWinningRank calculate(Lotto lotto, Lotto winningLotto) {
		int matches = (int)(lotto.getLottoNumberList().stream()
			.filter(number -> winningLotto.getLottoNumberList().contains(number))
			.count());

		return Arrays.stream(values())
			.filter(lottoWinningRank -> lottoWinningRank.numberOfMatches == matches)
			.findFirst()
			.orElse(NONE);
	}

	public static List<LottoWinningRank> getValidLottoWinningRankList() {
		List<LottoWinningRank> list = new ArrayList<>(Arrays.asList(values()));
		list.removeIf(rank -> rank.getNumberOfMatches() == NONE.numberOfMatches);

		return list;
	}
}
