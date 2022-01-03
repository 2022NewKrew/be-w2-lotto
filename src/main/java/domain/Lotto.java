package domain;

import java.util.List;

public class Lotto {
	private final List<Integer> lottoNumberList;

	public Lotto(List<Integer> lottoNumberList) {
		this.lottoNumberList = lottoNumberList;
	}

	public List<Integer> getLottoNumberList() {
		return lottoNumberList;
	}
}
