package View;

import java.util.List;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoStatistics;
import util.Message;

public class LottoOutputView {
	public static void printPurchaseAmount(int purchaseAmount) {
		System.out.println(purchaseAmount + Message.PURCHASE_LOTTO_NUMBER);
	}

	public static void printLotto(List<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			printLotto(lotto);
		}
		System.out.println();
	}

	public static void printLotto(Lotto lotto) {
		System.out.println(lotto.getLottoNumberList());
	}

	public static void printLottoStatistics(LottoStatistics lottoStatistics) {
		System.out.println();
		System.out.println(Message.LOTTO_STATISTICS_RESULT);
		System.out.println(Message.HORIZONTAL_LINE);

		for (LottoRank rank : LottoRank.getValidLottoRankList()) {
			System.out.print(rank.getMessage() + " (");
			System.out.print(rank.getReward() + "원) - ");
			System.out.println(lottoStatistics.getLottoRankMap().get(rank) + "개");
		}

		System.out.println(String.format(Message.PROFIT_RESULT, lottoStatistics.getProfit()));
	}
}
