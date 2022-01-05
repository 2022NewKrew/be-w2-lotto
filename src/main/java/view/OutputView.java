package view;

import domain.buyer.Yield;
import domain.lotto.Lotto;
import domain.result.Winning;

import java.util.List;

public class OutputView {
    public static class LazyHolder {
        public static final OutputView INSTANCE = new OutputView();
    }

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void showLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .forEach(System.out::println);
    }

    public void completeBuying(int buyingCnt, int inputBuyingCnt) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", inputBuyingCnt, buyingCnt - inputBuyingCnt);
    }

    public void showTotalHitting(List<Integer> hittingTable, int startIdx, int endIdx, Yield yield) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = startIdx; i >= endIdx; i--) {
            showRankPriceInfo(i, hittingTable.get(i));
        }
        showYield(yield);
    }

    private void showRankPriceInfo(int rank, int cnt) {
        int hittingCnt = Winning.hittingCntOfRank(rank);
        int price = Winning.priceOfRank(rank);

        System.out.println(hittingCnt + "개 일치" +
                (rank == 2 ? ",보너스 볼 일치" : " ") +
                "(" + price + "원)" +
                "- " + cnt + "개");
    }

    private void showYield(Yield yield) {
        System.out.println("총 수익률은 " + yield.getPercent() + "%입니다.");
    }
}
