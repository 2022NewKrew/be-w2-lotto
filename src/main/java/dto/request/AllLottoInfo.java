package dto.request;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import domain.Lotto;
import domain.WinningLotto;
import util.IOUtils;

public class AllLottoInfo {
	private final List<Lotto> lottoList;
	private final WinningLotto winningLotto;

	public AllLottoInfo(List<Lotto> lottoList, WinningLotto winningLotto) {
		this.lottoList = lottoList;
		this.winningLotto = winningLotto;
	}

	public AllLottoInfo(String lottoList, String winningNumber, String bonusNumber) {
		this.lottoList = getLottoList(lottoList);
		this.winningLotto = getWinningLotto(winningNumber, bonusNumber);
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}

	public WinningLotto getWinningLotto() {
		return winningLotto;
	}

	private List<Lotto> getLottoList(String lottoList) {
		String[] lottoArr = lottoList.split("]");
		List<Lotto> allLottoList = new ArrayList<>();

		for (String lottoStr : lottoArr) {
			allLottoList.add(
				new Lotto(
					IOUtils.stringTokenizerToIntegerList(new StringTokenizer(lottoStr, ",[ "))
				)
			);
		}

		return allLottoList;
	}

	private WinningLotto getWinningLotto(String winningNumber, String bonusNumber) {
		List<Integer> winningLottoList = IOUtils.stringTokenizerToIntegerList(new StringTokenizer(winningNumber, ","));

		return new WinningLotto(winningLottoList, Integer.parseInt(bonusNumber));
	}

}
