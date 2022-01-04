package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LottoRank {
	NONE(0, 0, false, "0개 일치"),
	FOURTH(3, 5000, false, "3개 일치"),
	THIRD(4, 50000, false, "4개 일치"),
	SECOND(5, 1500000, false, "5개 일치"),
	SECOND_BONUS(5, 30000000, true, "5개일치, 보너스 볼 일치"),
	FIRST(6, 2000000000, false, "6개 일치");

	private final int numberOfMatches;
	private final int reward;
	private final boolean bonus;
	private final String message;

	LottoRank(int numberOfMatches, int reward, boolean bonus, String message) {
		this.numberOfMatches = numberOfMatches;
		this.reward = reward;
		this.bonus = bonus;
		this.message = message;
	}

	public int getNumberOfMatches() {
		return numberOfMatches;
	}

	public int getReward() {
		return reward;
	}

	public boolean isBonus() {
		return bonus;
	}

	public String getMessage() {
		return message;
	}

	public static List<LottoRank> getValidLottoRankList() {
		List<LottoRank> list = new ArrayList<>(Arrays.asList(values()));
		list.removeIf(rank -> rank.getNumberOfMatches() == NONE.numberOfMatches);

		return list;
	}
}
