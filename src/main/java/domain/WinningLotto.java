package domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto extends Lotto {
	private int bonusNumber;

	public WinningLotto(List<Integer> lottoNumberList, int bonusNumber) {
		super(lottoNumberList);
		this.bonusNumber = bonusNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public LottoRank calculateRank(Lotto lotto) {
		int matches = (int)(lotto.getLottoNumberList().stream()
			.filter(number -> this.getLottoNumberList().contains(number))
			.count());

		LottoRank lottoRank = Arrays.stream(LottoRank.values())
			.filter(lottoWinningRank -> lottoWinningRank.getNumberOfMatches() == matches)
			.findFirst()
			.orElse(LottoRank.NONE);

		return lottoRank == LottoRank.SECOND ? checkBonus(lotto) : lottoRank;
	}

	private LottoRank checkBonus(Lotto lotto) {
		if (lotto.getLottoNumberList().contains(bonusNumber)) {
			return LottoRank.SECOND_BONUS;
		}

		return LottoRank.SECOND;
	}
}
